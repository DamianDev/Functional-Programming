package zad3;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;

public class DochodyPanel extends CalcPanel {

	CalcPanel pp;
	CalcPanel ku;

	public DochodyPanel(JCheckBox w, JCheckBox l, String text, PrzychodyPanel pp, KuPanel ku) {
		super(w, l, text);
		tf1.setEditable(false);
		tf2.setEditable(false);
		tf3.setEditable(false);
		this.pp = pp;
		this.ku = ku;
		info = "Dochód ze źródła: ";
	}

	public void setFocusListener1() {
		tf1.addFocusListener(new FocusListener() {
			
			@Override
			public void focusGained(FocusEvent e) {
				Main.infoLabel.setText(info +  "źródło1");
				tf1.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.blue));
				count1();
			}
	
			@Override
			public void focusLost(FocusEvent e) {
					tf1.setBorder(borderUneditable);
					tf1.setBackground(colorUneditable);
					if(wiersz.isSelected())
						Management.fillLine(1);
					if(podatek.isSelected())
						Management.autoFill();
			}
			
		});
	}
	
	public void setFocusListener2() {
		tf2.addFocusListener(new FocusListener() {
			
			@Override
			public void focusGained(FocusEvent e) {
				Main.infoLabel.setText(info +  "źródło2");
				tf2.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.blue));
				count2();
			}
	
			@Override
			public void focusLost(FocusEvent e) {
					tf2.setBorder(borderUneditable);
					tf2.setBackground(colorUneditable);
					if(wiersz.isSelected())
						Management.fillLine(2);
					if(podatek.isSelected())
						Management.autoFill();
			}
			
		});
	}
	
	public void setFocusListener3() {
		tf3.addFocusListener(new FocusListener() {
			
			@Override
			public void focusGained(FocusEvent e) {
				Main.infoLabel.setText(info +  "źródło3");
				tf3.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.blue));
				count3();
			}
	
			@Override
			public void focusLost(FocusEvent e) {
					tf3.setBorder(borderUneditable);
					tf3.setBackground(colorUneditable);
					if(wiersz.isSelected())
						Management.fillLine(3);
					if(podatek.isSelected())
						Management.autoFill();
			}
			
		});
	}
	
	public void count1() {
		if(!pp.getText1().equals("")) {
			if(!ku.getText1().equals(""))
				tf1.setText((Double.valueOf(pp.getText1())-Double.valueOf(ku.getText1())) + "");
			else
				tf1.setText(Double.valueOf(pp.getText1()) + "");
		}
		sumUp();
	}
	
	public void count2() {
		if(!pp.getText2().equals("")) {
			if(!ku.getText2().equals(""))
				tf2.setText((Double.valueOf(pp.getText2())-Double.valueOf(ku.getText2())) + "");
			else
				tf2.setText(Double.valueOf(pp.getText2()) + "");
		}
		sumUp();
	}
	
	public void count3() {
		if(!pp.getText3().equals("")) {
			if(!ku.getText3().equals(""))
				tf3.setText((Double.valueOf(pp.getText3())-Double.valueOf(ku.getText3())) + "");
			else
				tf3.setText(Double.valueOf(pp.getText3()) + "");
		}
		sumUp();
	}
	
}
