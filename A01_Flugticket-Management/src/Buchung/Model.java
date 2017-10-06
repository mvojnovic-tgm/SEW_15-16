package Buchung;

public class Model {

	private String country1;
	private String country2;
	
	private String airport1,airport2;
	
	public Model(){
		country1 = "None";
		country2 = "None";
		airport1 = "None";
		airport2 = "None";
	}
	
	public void setCountry1(String country){
		this.country1 = country;
	}
	
	public String getCountry1(){
		return this.country1;
	}
	
	public void setCountry2(String country){
		this.country2 = country;
	}
	
	public String getCountry2(){
		return this.country2;
	}

	public void setAirport1(String string) {
		this.airport1 = string;
		
	}
	public void setAirport2(String string) {
		this.airport2 = string;
		
	}
	
	public String getAirport1() {
		
		return this.airport1;
	}

	public String getAirport2() {
		
		return this.airport2;
	}
}
