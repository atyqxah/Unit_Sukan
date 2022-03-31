package us.DAO;

import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import us.connection.connectionmanagers;
import us.model.asset;
import us.model.item;
import us.model.nonAsset;

public class nonAssetDAO {
	static Connection currentCon = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
    static String productCode, nonAssetID, locations, conditions;
    
 public void add(nonAsset nonAsset) throws NoSuchAlgorithmException{
		
        productCode = nonAsset.getProductCode();
        nonAssetID = nonAsset.getNonAssetID();
        locations = nonAsset.getLocations();
        conditions = nonAsset.getConditions();
            
    	try {
    		currentCon = connectionmanagers.getConnection();
    		ps=currentCon.prepareStatement("insert into nonAsset (productCode, locations, conditions, nonAssetID)values(?,?,?,?)");
    		ps.setString(1,productCode);
    		ps.setString(4, nonAssetID);
    		ps.setString(2, locations);
    		ps.setString(3, conditions);
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
 
 
    public nonAsset getNonAssetById(item i) {
		nonAsset na = new nonAsset();		
		
		productCode = i.getProductCode();
			
		String searchQuery = "select * from nonAsset where productCode='" + productCode + "'";

     try {
         currentCon = connectionmanagers.getConnection();
         stmt = currentCon.createStatement();
         rs = stmt.executeQuery(searchQuery);
         boolean more = rs.next();

         // if user exists set the isValid variable to true
         if (more) {
         	na.setProductCode(i.getProductCode());
         	na.setDescription(i.getDescription());
         	na.setBrand(i.getBrand());
         	na.setModel(i.getModel());
         	na.setNote(i.getNote());
         	na.setBuydate(i.getBuydate());
         	na.setQuantity(i.getQuantity());
         	na.setPrice(i.getPrice());
         	na.setType(i.getType());
         	na.setNonAssetID(rs.getString("nonAssetID"));
         	na.setLocations(rs.getString("locations"));
         	na.setConditions(rs.getString("conditions"));
        	}
        
         else if (!more) {
         	System.out.println("Sorry");
         }
        
     }catch (SQLException e) {
	        e.printStackTrace();
	    }
     
	    return na;
	}
 
   public void updateNonAsset(nonAsset na) {
		
		productCode = na.getProductCode();
		nonAssetID = na.getNonAssetID();
	    locations = na.getLocations(); 
	    conditions = na.getConditions();
	   
	    String searchQuery = "UPDATE asset SET assetID='" + nonAssetID + "', locations ='" +  locations  + "', conditions ='" +conditions+"',  WHERE productCode= '" + productCode + "'";
		
		try {
	
	        currentCon = connectionmanagers.getConnection();
	        stmt = currentCon.createStatement();
	        stmt.executeUpdate(searchQuery);
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	}
   
   public void deleteNonAsset (String productCode) {
		String searchQuery = "delete from nonAsset where productCode=" + productCode;
		
		try {
	
	        currentCon = connectionmanagers.getConnection();
	        stmt = currentCon.createStatement();
	        stmt.executeUpdate(searchQuery);
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	}


}
