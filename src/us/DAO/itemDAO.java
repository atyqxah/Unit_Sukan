package us.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import us.connection.connectionmanagers;
import us.model.asset;
import us.model.item;
import us.model.nonAsset;

public class itemDAO {
	static Connection currentCon = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
	static String productCode, description, brand, model, note, buydate,type;
	int quantity;
	double price;
	
	public static item getItem(item i) {
		productCode = i.getProductCode();

        String searchQuery = "select * from item where productCode='" + productCode + "'";

        try {
            currentCon = connectionmanagers.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();
            
            System.out.println(searchQuery);

            // if subject exists set the isValid variable to true
            if (more) {
            	i.setValid(true);
           	}
           
            else if (!more) {
            	i.setValid(false);
            }
           
        }

        catch (Exception ex) {
            System.out.println("Log In failed: An Exception has occurred! " + ex);
        }

        finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                }
                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (Exception e) {
                }
                stmt = null;
            }

            if (currentCon != null) {
                try {
                    currentCon.close();
                } catch (Exception e) {
                }

                currentCon = null;
            }
        }

        return i;
	}

	public void add(item bean){		
		productCode = bean.getProductCode();
		description = bean.getDescription();
		brand = bean.getBrand();
		model = bean.getModel();
		note = bean.getNote();
		buydate = bean.getBuydate();
		quantity = bean.getQuantity();
		price = bean.getPrice(); 
		type = bean.getType();

		try {
			currentCon = connectionmanagers.getConnection();
			ps=currentCon.prepareStatement("insert into item(productCode,description,quantity,price,brand,model,note,buydate,type)values(?,?,?,?,?,?,?,?,?)");
			ps.setString(1,productCode);
			ps.setString(2,description);	
			ps.setString(5,brand);
			ps.setString(6,model);
			ps.setString(7,note);
			ps.setString(8,buydate);
			ps.setInt(3,quantity);
			ps.setDouble(4,price);
			ps.setString(9,type);


			ps.executeUpdate();
		}
		catch (Exception ex) {
			System.out.println("failed: An Exception has occurred! " + ex);
		}
		finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e) {
				}
				ps = null;
			}
			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}
				currentCon = null;
			}
		}
	}

	public static List<item> getAllItem() {
		List<item> Litem = new ArrayList<item>();
		try {
			currentCon = connectionmanagers.getConnection();
			stmt = currentCon.createStatement();
			ResultSet rs = stmt.executeQuery("select * from item order by productCode");

			while (rs.next()) {
				item i = new item();
				i.setProductCode(rs.getString("productCode"));
				i.setDescription(rs.getString("description"));
				i.setQuantity(rs.getInt("quantity"));
				i.setPrice(rs.getDouble("price"));
				i.setBrand(rs.getString("brand"));
				i.setModel(rs.getString("model"));
				i.setNote(rs.getString("note"));
				i.setBuydate(rs.getString("buydate"));
				i.setType(rs.getString("type"));
				Litem.add(i);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Litem;
	}
	
	public static nonAsset getItemById(String productCode) {
		//item i = new item();
		nonAsset i = new nonAsset();
	    try {
	    	currentCon = connectionmanagers.getConnection();
	        ps=currentCon.prepareStatement("select * from item i full outer join nonasset n on(i.productCode = n.productCode) where i.productCode=?");
	        
	        ps.setString(1, productCode);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {	            
				i.setProductCode(rs.getString("productCode"));
				i.setDescription(rs.getString("description"));
				i.setQuantity(rs.getInt("quantity"));
				i.setPrice(rs.getDouble("price"));
				i.setBrand(rs.getString("brand"));
				i.setModel(rs.getString("model"));
				i.setNote(rs.getString("note"));
				i.setBuydate(rs.getString("buydate"));
				i.setType(rs.getString("type"));
				i.setNonAssetID(rs.getString("nonAssetID"));
				i.setLocations(rs.getString("locations"));
				i.setConditions(rs.getString("conditions"));

	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return i;
	}
	
	public static asset getItemByPC(String productCode) {
		//item i = new item();
		asset i = new asset();
	    try {
	    	currentCon = connectionmanagers.getConnection();
	        ps=currentCon.prepareStatement("select * from item i full outer join asset n on(i.productCode = n.productCode) where i.productCode=?");
	        
	        ps.setString(1, productCode);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {	            
				i.setProductCode(rs.getString("productCode"));
				i.setDescription(rs.getString("description"));
				i.setQuantity(rs.getInt("quantity"));
				i.setPrice(rs.getDouble("price"));
				i.setBrand(rs.getString("brand"));
				i.setModel(rs.getString("model"));
				i.setNote(rs.getString("note"));
				i.setBuydate(rs.getString("buydate"));
				i.setType(rs.getString("type"));
				i.setAssetID(rs.getString("assetID"));
				i.setExpiredDate(rs.getString("expiredDate"));
				//i.setConditions(rs.getString("conditions"));

	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return i;
	}
	
	public void deleteItem(String productCode) {
	    try {
	    	currentCon = connectionmanagers.getConnection();
	    	ps=currentCon.prepareStatement("delete from item where productCode=?");
	        ps.setString(1, productCode);
	        ps.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void updateItem(String productCode) {
	    try {
	    	currentCon = connectionmanagers.getConnection();
	    	ps=currentCon.prepareStatement("update from item where productCode=?");
	        ps.setString(1, productCode);
	        ps.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	
	public void updateItem(item bean){		
		productCode = bean.getProductCode();
		description = bean.getDescription();
		brand = bean.getBrand();
		model = bean.getModel();
		note = bean.getNote();
		buydate = bean.getBuydate();
		quantity = bean.getQuantity();
		price = bean.getPrice();
		type = bean.getType();

		try {
			currentCon = connectionmanagers.getConnection();
			ps=currentCon.prepareStatement("update ITEM set QUANTITY=?, NOTE=? where PRODUCTCODE=?");
			ps.setInt(1,quantity);
			ps.setString(2,note);
			ps.setString(3,productCode);


			ps.executeUpdate();
		}
		catch (Exception ex) {
			System.out.println("failed: An Exception has occurred! " + ex);
		}
		finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (Exception e) {
				}
				ps = null;
			}
			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception e) {
				}
				currentCon = null;
			}
		}
	}
	
}

