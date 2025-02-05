package com.offers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class offerDBUtil {

	public static boolean insertoffer(String date, String date2, String offer) {

		boolean isSuccess = false;

		String url = "jdbc:mysql://localhost:3306/hotel";
		String user = "root";
		String pass = "Pasindu2002@";

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			String sql = "insert into offer values(0,'" + date + "','" + date2 + "','"+offer+"')";
			int rs = stmt.executeUpdate(sql);

			if (rs > 0) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		return isSuccess;

	}

	public static List<Offer> getOffers() {
		List<Offer> offers = new ArrayList<>();

		String url = "jdbc:mysql://localhost:3306/hotel";
		String user = "root";
		String pass = "Pasindu2002@";

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Connection con = DriverManager.getConnection(url, user, pass);
			Statement stmt = con.createStatement();
			String sql = "SELECT * FROM offer";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt(1);
				String date = rs.getString(2);
				String date2=rs.getString(3);
				String offer = rs.getString(4);

				offers.add(new Offer(id, date,date2,offer));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return offers;
	}

	public static boolean updateoffer(String no_id, String date, String date2, String offer) {
	    String url = "jdbc:mysql://localhost:3306/hotel";
	    String user = "root";
	    String pass = "Pasindu2002@";
	    
	    boolean isSuccess = false;
	    
	    try {
	        Class.forName("com.mysql.jdbc.Driver");
	        Connection con = DriverManager.getConnection(url, user, pass);
	        Statement stmt = con.createStatement();
	        
	        
	        String sql = "UPDATE offer SET date= '"+date+"', date2='"+date2+"', offer='"+offer+"' WHERE no_id='"+no_id+"'";
	        int rs = stmt.executeUpdate(sql);

	        if (rs > 0) {
	            isSuccess = true;
	        } else {
	            isSuccess = false;
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return isSuccess;
	}

	
	
	public static boolean deleteoffer(String no_id) {
		
		int convID=Integer.parseInt(no_id);
		
		String url = "jdbc:mysql://localhost:3306/hotel";
	    String user = "root";
	    String pass = "Pasindu2002@";
	    
	    boolean isSuccess = false;
	   
	    try {
	        Class.forName("com.mysql.jdbc.Driver");

	        Connection con = DriverManager.getConnection(url, user, pass);
	        Statement stmt = con.createStatement();
	        // Corrected SQL query
	        String sql = "DELETE from offer where no_id='"+convID+"'";
	        int rs = stmt.executeUpdate(sql);

	        if (rs > 0) {
	            isSuccess = true;
	        } else {
	            isSuccess = false;
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return isSuccess;
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
