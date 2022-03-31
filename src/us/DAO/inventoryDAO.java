package us.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import us.connection.connectionmanagers;
import us.model.inventory;
import us.model.staff;

public class inventoryDAO {
	static Connection currentCon = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
	String staffID, productCode, supID, latestDate;

	public void add(inventory bean){		
		staffID = bean.getStaffID();
		productCode = bean.getProductCode();
		supID = bean.getSupID();
		latestDate = bean.getLatestDate();

		try {
			currentCon = connectionmanagers.getConnection();
			ps=currentCon.prepareStatement("insert into invlog(staffID, productCode , supID, latestDate)values(?,?,?,?)");
			ps.setString(1,staffID);
			ps.setString(2,productCode);
			ps.setString(3,supID);	
			ps.setString(4,latestDate);

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
	
	public static List<inventory> getAllInventory() {
		List<inventory> Linventory = new ArrayList<inventory>();
		try {
			currentCon = connectionmanagers.getConnection();
			stmt = currentCon.createStatement();
			ResultSet rs = stmt.executeQuery("select * from invLog");

			while (rs.next()) {
				inventory s = new inventory();
				s.setStaffID(rs.getString("staffID"));
				s.setProductCode(rs.getString("productCode"));
				s.setSupID(rs.getString("supID"));
				s.setLatestDate(rs.getString("latestDate"));
				Linventory.add(s);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Linventory;
	}
	

}
