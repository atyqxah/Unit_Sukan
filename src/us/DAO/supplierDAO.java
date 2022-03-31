package us.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import us.connection.connectionmanagers;
import us.model.supplier;

public class supplierDAO {
	static Connection currentCon = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
	String supid,supname,supemail,supaddress;
	int supcontact;
	
	public void add(supplier bean){		
		supid = bean.getSupid();
		supname = bean.getSupname();
		supemail = bean.getSupemail();
		supcontact = bean.getSupcontact();
		supaddress = bean.getSupaddress();


		try {
			currentCon = connectionmanagers.getConnection();
			ps=currentCon.prepareStatement("insert into supplier(supid, supname, supemail, supcontact, compadd)values(?,?,?,?,?)");
			ps.setString(1,supid);
			ps.setString(2,supname);
			ps.setString(3,supemail);	
			ps.setInt(4,supcontact);
			ps.setString(5,supaddress);




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
	
	public static List<supplier> getAllSupplier() {
		List<supplier> Lsup = new ArrayList<supplier>();
		try {
			currentCon = connectionmanagers.getConnection();
			stmt = currentCon.createStatement();
			ResultSet rs = stmt.executeQuery("select * from supplier order by supid");

			while (rs.next()) {
				supplier s = new supplier();
				s.setSupid(rs.getString("supid"));
				s.setSupname(rs.getString("supname"));
				s.setSupemail(rs.getString("supemail"));
				s.setSupcontact(rs.getInt("supcontact"));
				s.setSupaddress(rs.getString("compadd"));
				Lsup.add(s);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Lsup;
	}
	
	public static supplier getSupplierById(String supid) {
		supplier s = new supplier();
	    try {
	    	currentCon = connectionmanagers.getConnection();
	        ps=currentCon.prepareStatement("select * from supplier where supid=?");
	        
	        ps.setString(1, supid);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {	            
	        	s.setSupid(rs.getString("supid"));
				s.setSupname(rs.getString("supname"));
				s.setSupemail(rs.getString("supemail"));
				s.setSupcontact(rs.getInt("supcontact"));
				s.setSupaddress(rs.getString("compadd"));

	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return s;
	}
	
	public void deleteSupplier(String supid) {
	    try {
	    	currentCon = connectionmanagers.getConnection();
	    	ps=currentCon.prepareStatement("delete from supplier where supid=?");
	        ps.setString(1, supid);
	        ps.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	
	
	public void updateSupplier(supplier bean){		
		supid = bean.getSupid();
		supname = bean.getSupname();
		supemail = bean.getSupemail();
		supcontact = bean.getSupcontact();
		supaddress = bean.getSupaddress();


		try {
			currentCon = connectionmanagers.getConnection();
			ps=currentCon.prepareStatement("UPDATE SUPPLIER set SUPNAME=?, SUPEMAIL=?, SUPCONTACT=?, COMPADD=? where SUPID=?");
			
			ps.setString(1,supname);
			System.out.println(supname);
			
			ps.setString(2,supemail);	
			System.out.println(supemail);
			
			ps.setInt(3,supcontact);
			System.out.println(supcontact);
			
			ps.setString(4,supaddress);
			System.out.println(supaddress);
			
			ps.setString(5,supid);
			System.out.println(supid);



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
