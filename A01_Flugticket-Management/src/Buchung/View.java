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
	JComboBox dd_country2;
	JComboBox dd_airport2;
	
	JButton b;
	
	public View(Control c, Model m){
		this.c = c;
		this.m = m;
		f = new JFrame("Buchung");
		p = new JPanel();
		
		JLabel l1 = new JLabel("From country:");
		JLabel l_air1 = new JLabel("From airport:");
		JLabel l2 = new JLabel("To country:");
		JLabel l_air2 = new JLabel("To airport:");
		
		b = new JButton("search");
		
		dd_country1 = new JComboBox(this.c.getCountries());
		dd_country2 = new JComboBox(this.c.getCountries());
		dd_country1.setSelectedItem(this.m.getCountry1());
		dd_country2.setSelectedItem(this.m.getCountry2());
		dd_airport1 = new JComboBox();
		dd_airport2 = new JComboBox();
		
		dd_country1.addActionListener(this);
		dd_country2.addActionListener(this);
		
		
		if(this.m.getCountry1().equals("None")){
			dd_airport1.disable();
		}else{
			dd_airport1 = new JComboBox(this.c.getAirport(this.m.getCountry1()));
		}
		
		if(this.m.getCountry2().equals("None")){
			dd_airport2.disable();
		}else{
			dd_airport2 = new JComboBox(this.c.getAirport(this.m.getCountry2()));
		}
		
		dd_airport1.addActionListener(this);
		dd_airport2.addActionListener(this);
		
		b.setEnabled(false);
		b.addActionListener(this);
		
		p.add(b);
		p.add(l1);
		p.add(dd_country1);
		p.add(l_air1);
		p.add(dd_airport1);
		
		p.add(l2);
		p.add(dd_country2);
		p.add(l_air2);
		p.add(dd_airport2);
		
		
		f.add(p);
		f.setSize(1920,100);
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.dd_country1){
			this.m.setCountry1(this.dd_country1.getSelectedItem().toString());
			//System.out.println(this.m.getCountry1());
			this.c.restart();
			f.dispose();
		}
		
		if(e.getSource() == this.dd_country2){
			this.m.setCountry2(this.dd_country2.getSelectedItem().toString());
			//System.out.println(this.m.getCountry2());
			this.c.restart();
			f.dispose();
		}
		
		if(e.getSource() == this.dd_airport1){
			this.m.setAirport1(this.dd_airport1.getSelectedItem().toString());
			if(!this.m.getAirport2().equals("None")){
				this.b.setEnabled(true);
			}
		}
		
		if(e.getSource() == this.dd_airport2){
			this.m.setAirport2(this.dd_airport2.getSelectedItem().toString());
			if(!this.m.getAirport1().equals("None")){
				this.b.setEnabled(true);
			}
		}
		if(e.getSource() == this.b){
			this.c.getFlights(this.m.getAirport1(), this.m.getAirport2());
		}
		
		
		
	}
	
	
}
