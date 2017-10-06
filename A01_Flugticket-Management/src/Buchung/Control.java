package Buchung;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Control {
	Connection con;
	View v;
	public Control(){
		v = new View(this);
		
		try{
			Class.forName("com.mysql.jdbc.Driver"); 
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/flightdata",
					"root","ml7875mysql");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private ArrayList<String> getCountries() throws SQLException{
		ArrayList<String> al = new ArrayList<String>();
		String query = "select name from countries";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		while(rs.next()){
			al.add(rs.getString("name"));
		}
		return al;
	}
	
	private ArrayList<String> getAirport(String country) throws SQLException{
		ArrayList<String> al = new ArrayList<String>();
		String query = "select name from airports where country="+country;
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		while(rs.next()){
			al.add(rs.getString("name"));
		}
		return al;
	}
}
