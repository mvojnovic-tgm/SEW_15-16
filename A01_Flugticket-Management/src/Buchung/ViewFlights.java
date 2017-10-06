package Buchung;

import java.util.ArrayList;

import javax.swing.*;

public class ViewFlights {

	Control c;
	Model m;
	JFrame f;
	
	public ViewFlights(Control c, Model m, ArrayList<String[]> flights){
		
		f= new JFrame();
		
		if(flights.size()<1){
			JLabel l = new JLabel("Keine Fluege zwischen diesen Flughaefen");
			f.add(l);
		}else{
		
		}
		f.setLocation(0, 100);
		f.setSize(1000,1000);
		f.setVisible(true);
	}
	
}
