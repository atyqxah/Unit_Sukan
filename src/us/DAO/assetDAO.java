package us.DAO;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import us.model.asset;
import us.model.item;
import us.connection.connectionmanagers;


public class assetDAO {
	static Connection currentCon = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
    static String productCode, assetID, expiredDate;
    
    public void add(asset asset) throws NoSuchAlgorithmException{
		
        productCode = asset.getProductCode();
        //sid = organic.getSupplierId();
        assetID = asset.getAssetID();
        expiredDate = asset.getExpiredDate();
            
    	try {
    		currentCon = connectionmanagers.getConnection();
    		ps=currentCon.prepareStatement("insert into asset (productCode, expiredDate, assetID)values(?,?,?)");
    		ps.setString(1,productCode);
    		ps.setString(3, assetID);
    		ps.setString(2,expiredDate);
    		ps.executeUpdate();
    	
    		//System.out.println("Product id is: " + id);
    		//System.out.println("Plant Name is: " + organicPlantName);
    		//System.out.println("Quantity: " +plantQty);
            
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
    
    public asset getAssetById(item i) {
		asset a = new asset();		
		
		productCode = i.getProductCode();
			
		String searchQuery = "select * from asset where productCode='" + productCode + "'";

        try {
            currentCon = connectionmanagers.getConnection();
            stmt = currentCon.createStatement();
            rs = stmt.executeQuery(searchQuery);
            boolean more = rs.next();

            // if user exists set the isValid variable to true
            if (more) {
            	a.setProductCode(i.getProductCode());
            	a.setDescription(i.getDescription());
            	a.setBrand(i.getBrand());
            	a.setModel(i.getModel());
            	a.setNote(i.getNote());
            	a.setBuydate(i.getBuydate());
            	a.setQuantity(i.getQuantity());
            	a.setPrice(i.getPrice());
            	a.setType(i.getType());
            	a.setAssetID(rs.getString("AssetID"));
            	a.setExpiredDate(rs.getString("ExpiredDate"));
           	}
           
            else if (!more) {
            	System.out.println("Sorry");
            }
           
        }catch (SQLException e) {
	        e.printStackTrace();
	    }
        
	    return a;
	}
    
   public void updateAsset(asset a) {
		
		productCode = a.getProductCode();
		assetID = a.getAssetID();
	    expiredDate = a.getExpiredDate(); 
	   
	    String searchQuery = "UPDATE asset SET assetID='" + assetID + "',expiredDate='" + expiredDate + "'  WHERE productCode= '" + productCode + "'";
		
		try {
	
	        currentCon = connectionmanagers.getConnection();
	        stmt = currentCon.createStatement();
	        stmt.executeUpdate(searchQuery);
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	}
   
   public void deleteAsset (String productCode) {
		String searchQuery = "delete from asset where productCode=" + productCode;
		
		try {
	
	        currentCon = connectionmanagers.getConnection();
	        stmt = currentCon.createStatement();
	        stmt.executeUpdate(searchQuery);
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	}

}
