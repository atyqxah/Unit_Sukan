package us.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import us.model.staff;

public class connectionmanagers {
	
	static Connection con;

	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String DB_USER = "sports";
	private static final String DB_PASSWORD = "system";
	
    public static Connection getConnection() {

        try {

            Class.forName(DB_DRIVER);

            try {
                con = DriverManager.getConnection(DB_CONNECTION,DB_USER,DB_PASSWORD);
                System.out.println("connected");

            }

            catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        return con;
    }
    
  //staffLogin
  	public staff login(String staffID, String staffPassword) throws SQLException {
  		connectionmanagers cm = new connectionmanagers();
  		Connection con = cm.getConnection();
  		
  		try {
  			String sql = "select * from STAFF where STAFFID=? and STAFFPASSWORD=?";
  			PreparedStatement ps = con.prepareStatement(sql);
  			
  			ps.setString(1, staffID);
  			ps.setString(2, staffPassword);
  			ps.executeQuery();
  			
  			ResultSet rs = ps.executeQuery();
  			
  			if(rs.next()) {	
  				staff s = new staff();
  				s.setStaffID(rs.getString("STAFFID"));	
  				s.setStaffPassword(rs.getString("STAFFPASSWORD"));	
  				s.setStaffRole(rs.getString("STAFFROLE"));
  				s.setStaffName(rs.getString("STAFFNAME"));	
  				return s;
  			}
  		}
  		catch (SQLException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}finally{
  			con.close();
  		}
  		return null;
  	}


}
