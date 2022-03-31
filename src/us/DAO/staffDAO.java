package us.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Response;

import us.connection.connectionmanagers;
import us.model.staff;

public class staffDAO {
	static Connection currentCon = null;
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
	String staffID, staffPassword, staffName, staffContact, staffEmail, staffRole, staffStatus;

	public void add(staff bean){		
		staffID = bean.getStaffID();
		staffPassword = bean.getStaffPassword();
		staffName = bean.getStaffName();
		staffContact = bean.getStaffContact();
		staffEmail = bean.getStaffEmail();
		staffRole = bean.getStaffRole();
		staffStatus = bean.getStaffStatus();


		try {
			currentCon = connectionmanagers.getConnection();
			ps=currentCon.prepareStatement("insert into staff(staffID, staffPassword, staffName, staffContact, staffEmail, staffRole, staffStatus)values(?,?,?,?,?,?,?)");
			ps.setString(1,staffID);
			ps.setString(2,staffPassword);
			ps.setString(3,staffName);	
			ps.setString(4,staffContact);
			ps.setString(5,staffEmail);
			ps.setString(6,staffRole);
			ps.setString(7,staffStatus);



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

	public static List<staff> getAllStaff() {
		List<staff> Lstaff = new ArrayList<staff>();
		try {
			currentCon = connectionmanagers.getConnection();
			stmt = currentCon.createStatement();
			ResultSet rs = stmt.executeQuery("select * from staff where STAFFROLE = 'staff' order by staffID");

			while (rs.next()) {
				staff s = new staff();
				s.setStaffID(rs.getString("staffID"));
				s.setStaffPassword(rs.getString("staffPassword"));
				s.setStaffName(rs.getString("staffName"));
				s.setStaffContact(rs.getString("staffContact"));
				s.setStaffEmail(rs.getString("staffEmail"));
				s.setStaffRole(rs.getString("staffRole"));
				s.setStaffStatus(rs.getString("staffStatus"));
				Lstaff.add(s);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Lstaff;
	}
	
	public static staff getStaffById(String staffID) {
		staff s = new staff();
	    try {
	    	currentCon = connectionmanagers.getConnection();
	        ps=currentCon.prepareStatement("select * from staff where staffID=?");
	        
	        ps.setString(1, staffID);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {	            
	        	s.setStaffID(rs.getString("staffID"));
				s.setStaffPassword(rs.getString("staffPassword"));
				s.setStaffName(rs.getString("staffName"));
				s.setStaffContact(rs.getString("staffContact"));
				s.setStaffEmail(rs.getString("staffEmail"));
				s.setStaffRole(rs.getString("staffRole"));
				s.setStaffStatus(rs.getString("staffStatus"));

	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return s;
	}
	
	public void deleteStaff(String staffID) {
	    try {
	    	currentCon = connectionmanagers.getConnection();
	    	ps=currentCon.prepareStatement("delete from staff where staffID=?");
	        ps.setString(1, staffID);
	        ps.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	
	
	
	public void updateStaff(staff bean){		
		staffID = bean.getStaffID();
		staffPassword = bean.getStaffPassword();
		staffName = bean.getStaffName();
		staffContact = bean.getStaffContact();
		staffEmail = bean.getStaffEmail();
		staffRole = bean.getStaffRole();
		staffStatus = bean.getStaffStatus();

		
		try {
			currentCon = connectionmanagers.getConnection();
			ps=currentCon.prepareStatement("update STAFF set STAFFNAME=?, STAFFPASSWORD=?, STAFFCONTACT=?, STAFFEMAIL=?, STAFFROLE=?, STAFFSTATUS=? where staffID=?");
			//System.out.println(staffID);
			ps.setString(1,staffName);	
			//System.out.println(staffName);
			ps.setString(2,staffPassword);	
			//System.out.println(staffName);
			ps.setString(3,staffContact);
			//System.out.println(staffContact);
			ps.setString(4,staffEmail);
			//System.out.println(staffEmail);
			ps.setString(5,staffRole);
			//System.out.println(staffRole);
			ps.setString(6,staffStatus);
			//System.out.println(staffStatus);
			ps.setString(7,staffID);
			
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
