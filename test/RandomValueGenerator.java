
public class RandomValueGenerator {

	public int testRnd(int i , int j){
		return (int)(Math.random()*i)+1;
	}
	
	public double temp(int i, int j){
		return Math.random()*90-10;
	}
	
	public double akt_Strom(int i, int j){
		return Math.random()*150;
	}
	
	public int d_Zahl(int i, int j){
		return (int)(Math.random()*100);
	}
	
	public int b_Pos(int i, int j){
		return (int)(Math.random()*360);
	}
	
	public double wind_v(int i, int j){
		return Math.random()*150;
	}
	
	public double b_Leistung(int i, int j){
		return Math.random()*45;
	}
}
