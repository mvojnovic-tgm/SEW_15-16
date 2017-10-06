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
	Model m;
	public Control(){
		
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver"); 
			this.con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/flightdata",
					"root","ml7875mysql");
		}catch(Exception e){
			e.printStackTrace();
		}
		m = new Model();
		v = new View(this,m);
		
	}
	
	public String[] getCountries(){
		try{
		ArrayList<String> al = new ArrayList<String>();
		String query = "select name from countries";
		Statement stmt = this.con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		while(rs.next()){
			al.add(rs.getString("name"));
		}
		String[] ret = new String[al.size()+1];
		ret[0] = "None";
		for(int i=0;i<ret.length-1;i++){
			ret[i+1]=al.get(i);
		}
		//String[] help = {"lel",";2;"};
		return ret;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return  null;
	}
	
	public String[] getAirport(String country){
		try{
		String helpQuery = "select code from countries where name='"+country+"'";
		Statement helpStmt = con.createStatement();
		ResultSet helpRs = helpStmt.executeQuery(helpQuery);
		String help = "";
		while(helpRs.next())help = helpRs.getString("code");
		
		ArrayList<String> al = new ArrayList<String>();
		String query = "select name from airports where country='"+help+"'";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		while(rs.next()){
			al.add(rs.getString("name"));
		}
		String[] ret = new String[al.size()+1];
		ret[0] = "None";
		for(int i=0;i<ret.length-1;i++){
			ret[i+1]=al.get(i);
		}
		return ret;
		}catch(SQLException e){
			e.printStackTrace();
		}
		return  null;
	}

	public void restart() {
		this.v = new View(this,m);
		
	}


	
}
