package jdbcdemo;

import java.sql.DriverManager;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

public class JDBCDemo {

	public static void main(String[] args) throws Throwable{
		
		Connection cnn;
		
		
		cnn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1/webshop");
		
		
		Statement start = cnn.createStatement();
		String query = "select * from artikel";
		ResultSet rs = start.executeQuery(query);
		
	}
	
}
