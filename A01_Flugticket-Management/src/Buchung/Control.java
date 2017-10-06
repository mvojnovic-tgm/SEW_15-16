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
	ViewFlights v_flights;
	ViewPass v_pass;
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
	
	public void getFlights(String fromAP, String toAP){
		String helpQuery1 = "select airportcode from airports where name='"+fromAP+"'";
		String helpQuery2 = "select airportcode from airports where name='"+toAP+"'";
		String fromAP_code = "";
		String toAP_code = "";
		try {
			Statement helpStmt1 = con.createStatement();
			Statement helpStmt2 = con.createStatement();
			
			ResultSet helpRs1 = helpStmt1.executeQuery(helpQuery1);
			ResultSet helpRs2 = helpStmt2.executeQuery(helpQuery2);
			while(helpRs1.next()){
				fromAP_code = helpRs1.getString("airportcode");
			}
			while(helpRs2.next()){
				toAP_code = helpRs2.getString("airportcode");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		
		String query = "select airline,flightnr,departure_time,destination_time,planetype  from flights where departure_airport='"+fromAP_code+"' AND  destination_airport='"+toAP_code+"'";
		ArrayList<String[]> al = new ArrayList<String[]>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()){
				String[] help = new String[5];
				help[0] = rs.getString("airline");
				help[1] = rs.getString("flightnr");
				help[2] = rs.getString("departure_time");
				help[3] = rs.getString("destination_time");
				help[4] = ""+rs.getInt("planetype");
				al.add(help);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.v_flights = new ViewFlights(this,m,al);
		
	}

	public void getPassengers(String string) {
		System.out.print(string);
		
	}


	
}
