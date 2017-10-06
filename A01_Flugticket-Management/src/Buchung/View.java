package Buchung;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

public class View  implements ActionListener{
	Control c;
	Model m;
	JFrame f;
	JPanel p;
	JComboBox dd_country1;
	JComboBox dd_airport1;
	
	public View(Control c, Model m){
		this.c = c;
		this.m = m;
		f = new JFrame("Buchung");
		p = new JPanel();
		
		JLabel l1 = new JLabel("From country:");
		JLabel l_air1 = new JLabel("From airport:");
		dd_country1 = new JComboBox(this.c.getCountries());
		dd_country1.setSelectedItem(this.m.getCountry1());
		dd_airport1 = new JComboBox();
		
		dd_country1.addActionListener(this);
		
		
		if(this.m.getCountry1().equals("None")){
			dd_airport1.disable();
		}else{
			dd_airport1 = new JComboBox(this.c.getAirport(this.m.getCountry1()));
		}
		
		dd_airport1.addActionListener(this);
		
		p.add(l1);
		p.add(dd_country1);
		p.add(l_air1);
		p.add(dd_airport1);
		
		
		f.add(p);
		f.setSize(1920,500);
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//if(e.getSource().equals("dd_country1")){
			this.m.setCountry1(dd_country1.getSelectedItem().toString());
			System.out.println(this.m.getCountry1());
			this.c.restart();
			f.dispose();
		//}
		
	}
	
	
}
