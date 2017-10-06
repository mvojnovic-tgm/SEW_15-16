package Buchung;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class ViewPass implements ActionListener{
	
	Control c;
	JFrame f;
	JButton[] bs;
	JLabel[] ls;
	JPanel[] ps;
	JPanel p;
	
	public ViewPass(Control c, String flight, ArrayList<String[]> passengers){
		this.c = c;
		f = new JFrame("Passengers from Flight: "+flight);
		p = new JPanel();
		bs = new JButton[passengers.size()];
		ps = new JPanel[passengers.size()];
		ls = new JLabel[passengers.size()];
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		for(int i = 0; i<bs.length;i++){
			bs[i] = new JButton("change");
			ls[i] = new JLabel(passengers.get(i)[0]+" ; "
					+passengers.get(i)[1]+" ; "+passengers.get(i)[2]
					+" ; "+passengers.get(i)[3]+" ; "
					+passengers.get(i)[4]+" ; "+passengers.get(i)[5]+" ; "
					+passengers.get(i)[6]);
			ps[i] = new JPanel();
			ps[i].add(bs[i]);
			ps[i].add(ls[i]);
			p.add(ps[i]);
		}
		
		f.add(p);
		f.setVisible(true);
		f.setLocation(1000, 100);
		f.setSize(1000, 1000);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
