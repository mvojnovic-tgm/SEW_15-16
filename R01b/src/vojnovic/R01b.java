package vojnovic;

import java.util.Scanner;

public class R01b {
	
	public static void main(String[] args){
		System.out.println("Wie oft soll 'Hallo' ausgegeben werden?");
		Scanner s = new Scanner(System.in);
		
		int x = s.nextInt();
		halloR(x);
	}
	
	public static void halloR(int i){
		i--;
		if(i>=0){
			System.out.println("Hallo");
			halloR(i);
		}
		
	}
}
