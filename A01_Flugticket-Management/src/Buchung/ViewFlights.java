package Buchung;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class ViewFlights implements ActionListener{

	Control c;
	Model m;
	JFrame f;
	JButton[] bs;
	JLabel[] ls;
	JPanel[] ps;
	JPanel p;
	ArrayList<String[]> al;
	
	public ViewFlights(Control c, Model m, ArrayList<String[]> flights){
		this.c = c;
		this.m = m;
		al = flights;
		f= new JFrame();
		p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		p.add(new JLabel("airline ; flightnr ; departure_time ; destination_time ; planetype"));
		
		if(flights.size()<1){
			JLabel l = new JLabel("Keine Fluege zwischen diesen Flughaefen");
			p.add(l);
		}else{
			bs = new JButton[flights.size()];
			ls = new JLabel[flights.size()];
			ps = new JPanel[flights.size()];
			for(int i = 0; i<bs.length; i++){
				ps[i] = new JPanel();
				bs[i] = new JButton("Passengers");
				bs[i].addActionListener(this);
				ps[i].add(bs[i]);
				ls[i] = new JLabel(flights.get(i)[0]+" ; "
						+flights.get(i)[1]+" ; "+flights.get(i)[2]
						+" ; "+flights.get(i)[3]+" ; "
						+flights.get(i)[4]);
				ps[i].add(ls[i]);
				p.add(ps[i]);
			}
		}
		f.add(p);
		f.setLocation(0, 100);
		f.setSize(1000,1000);
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i<bs.length; i++){
			if(e.getSource() == bs[i])this.c.getPassengers(al.get(i)[1]);
		}
		
	}
	
}
