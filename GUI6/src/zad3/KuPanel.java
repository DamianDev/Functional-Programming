package zad3;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;

public class KuPanel extends CalcPanel {

	CalcPanel pp;
	CalcPanel kp;
	
	public KuPanel(JCheckBox w, JCheckBox l, String text, PrzychodyPanel pp, KupPanel kp) {
		super(w, l, text);
		this.pp = pp;
		this.kp = kp;
		info = "Koszty uzyskania przychodu ze źródła: ";
	}

public void setFocusListener1() {
		
		tf1.addFocusListener(new FocusListener() {
			
			@Override
			public void focusGained(FocusEvent e) {
				Main.infoLabel.setText(info +  "źródło1");
				tf1.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
				count1();
				sumUp();
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(!pp.getText1().equals("") && !kp.getText1().equals(""))
					tf1.setText(Double.valueOf(pp.getText1())*Double.valueOf(kp.getText1())/100 + "");
				tf1.setBorder(borderEditable);
				tf1.setBackground(colorEditable);
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
				tf2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
				count2();
				sumUp();
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(!pp.getText2().equals("") && !kp.getText2().equals(""))
					tf2.setText(Double.valueOf(pp.getText2())*Double.valueOf(kp.getText2())/100 + "");
				tf2.setBorder(borderEditable);
				tf2.setBackground(colorEditable);
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
			tf3.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red));
			count3();
			sumUp();
		}

		@Override
		public void focusLost(FocusEvent e) {
			if(!pp.getText3().equals("") && !kp.getText3().equals(""))
				tf3.setText(Double.valueOf(pp.getText3())*Double.valueOf(kp.getText3())/100 + "");
			tf3.setBorder(borderEditable);
			tf3.setBackground(colorEditable);
			if(wiersz.isSelected())
				Management.fillLine(3);
			if(podatek.isSelected())
				Management.autoFill();
		}
		
	});
	
}

	public void setFocusListener4() {
	
		tf4.addFocusListener(new FocusListener() {
	
			@Override
			public void focusGained(FocusEvent e) {
				Main.infoLabel.setText(info +  "Suma ze wszystkich źródeł");
				tf4.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.blue));
			}
	
			@Override
			public void focusLost(FocusEvent e) {
					tf4.setBorder(borderUneditable);
					tf4.setBackground(colorUneditable);
			}
			
		});
	}
	
	public void count1() {
		if(!pp.getText1().equals("")) {
			if(!kp.getText1().equals(""))
				tf1.setText(Double.valueOf(pp.getText1())*Double.valueOf(kp.getText1())/100 + "");
			else
				tf1.setText(pp.getText1());
		}
	}
	
	public void count2() {
		if(!pp.getText1().equals("")) {
			if(!kp.getText2().equals(""))
				tf2.setText(Double.valueOf(pp.getText2())*Double.valueOf(kp.getText2())/100 + "");
			else
				tf2.setText(pp.getText2());
		}
	}
	
	public void count3() {
		if(!pp.getText3().equals("")) {
			if(!kp.getText3().equals(""))
				tf3.setText(Double.valueOf(pp.getText3())*Double.valueOf(kp.getText3())/100 + "");
			else
				tf3.setText(pp.getText3());
		}
	}

}
