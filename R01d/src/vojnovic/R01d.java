package vojnovic;

import java.io.*;
import java.util.Scanner;

public class R01d {
	
	public static void main(String[] args){
		System.out.println("Verzeichnis");
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		File here = new File(s);
		String[] dir = here.list();
		if (dir != null) { // Verzeichnis ist nicht leer
		 for (int i = 0; i < dir.length; i++) {
		 File f = new File(here, dir[i]);
		 if (f.isDirectory())
		 System.out.println("Directory " + dir[i]);
		 if (f.isFile())
		 System.out.println("File " + dir[i]);
		 }
		 
		}

	}
	
}
