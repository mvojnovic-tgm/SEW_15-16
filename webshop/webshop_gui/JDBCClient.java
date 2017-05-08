package webshop_gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JDBCClient {

	Connection con;
	
	JDBCClient(){
		try{
			con = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/webshop","postgres","postgres");
		}catch(Exception e){
			
		}
	}
	
	List<Artikel> getAllArticles() {
		List<Artikel> a = new ArrayList<Artikel>();
		
		try{
			Statement s = con.createStatement();
			String query = "SELECT * from artikel";
			ResultSet rs = s.executeQuery(query);
			
			
			while(rs.next()){
				int anr = rs.getInt("anr");
				//und so weiter
				//a.add(new Artikel(anr));
			}
		}catch(Exception e){
			
		}
		
		return a;
	}

	void addArticle(Artikel a) {
		
		try {
			PreparedStatement ps = con.prepareStatement("INSERT ......... values(?,?,?,?,?)");
			ps.setInt(1,a.getAnr());
			//blablabla setSttring etc.
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	void saveArticle(Artikel a) {
	}
}
