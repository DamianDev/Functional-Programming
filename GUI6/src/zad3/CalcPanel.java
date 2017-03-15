package zad3;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class CalcPanel extends JPanel {

	public JLabel title;
	public JTextField tf1 = new JTextField(10);
	public JTextField tf2 = new JTextField(10);
	public JTextField tf3 = new JTextField(10);
	public JTextField tf4 = new JTextField(10);
	protected Border borderEditable = tf1.getBorder();
	protected Color colorEditable = tf1.getBackground();
	protected Border borderUneditable;
	protected Color colorUneditable;
	protected JCheckBox wiersz;
	protected JCheckBox podatek;
	protected String info;
	
	public CalcPanel(JCheckBox wiersz, JCheckBox podatek, String text) {
		this.wiersz = wiersz;
		this.podatek = podatek;
		this.setLayout(new GridLayout(0,1));
		title = new JLabel(text, SwingConstants.CENTER);
		this.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
		
		tf4.setEditable(false);
		borderUneditable = tf4.getBorder();
		colorUneditable = tf4.getBackground();
		
		setFocusListener1();
		setFocusListener2();
		setFocusListener3();
		setFocusListener4();
		
		this.add(title);
		this.add(tf1);
		this.add(tf2);
		this.add(tf3);
		this.add(tf4);
		
	}
	
	public boolean isNumber(String text) {
		
		String patternString = "\\s*\\d*\\.*\\d*\\s*";

        Pattern pattern = Pattern.compile(patternString);

        Matcher matcher = pattern.matcher(text);
        boolean matches = matcher.matches();
		
		return matches;
	}
	
	public void setFocusListener1() {
		
		tf1.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				tf1.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.red));
				Main.infoLabel.setText(info +  "źródło1");
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(isNumber(tf1.getText()) || tf1.getText().equals("")) {
					tf1.setBorder(borderEditable);
					tf1.setBackground(colorEditable);
					sumUp();
				}
				else {
					tf1.requestFocus();
					tf1.setBackground(Color.yellow);
				}
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
				tf2.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.red));
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(wiersz.isSelected())
					Management.fillLine(2);
				if(podatek.isSelected())
					Management.autoFill();
				if(isNumber(tf2.getText()) || tf2.getText().equals("")) {
					tf2.setBorder(borderEditable);
					tf2.setBackground(colorEditable);
					sumUp();
				}
				else {
					tf2.requestFocus();
					tf2.setBackground(Color.yellow);
				}
			}
			
		});
		
	}

	public void setFocusListener3() {
	
	tf3.addFocusListener(new FocusListener() {

		@Override
		public void focusGained(FocusEvent e) {
			Main.infoLabel.setText(info +  "źródło3");
			tf3.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.red));
		}

		@Override
		public void focusLost(FocusEvent e) {
			if(wiersz.isSelected())
				Management.fillLine(3);
			if(podatek.isSelected())
				Management.autoFill();
			if(isNumber(tf3.getText()) || tf3.getText().equals("")) {
				tf3.setBorder(borderEditable);
				tf3.setBackground(colorEditable);
				sumUp();
			}
			else {
				tf3.requestFocus();
				tf3.setBackground(Color.yellow);
			}
		}
		
	});
	
}

	public void setFocusListener4() {
	
		tf4.addFocusListener(new FocusListener() {
	
			@Override
			public void focusGained(FocusEvent e) {
				Main.infoLabel.setText(info +  "Suma ze wszystkich źródeł");
				tf4.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.blue));
				sumUp();
			}
	
			@Override
			public void focusLost(FocusEvent e) {
					tf4.setBorder(borderUneditable);
					tf4.setBackground(colorUneditable);
			}
			
		});
	}
	
	public void sumUp() {
		double suma = 0;
		if(!tf1.getText().equals("") || !tf2.getText().equals("") || !tf3.getText().equals("")) {
			if(!tf1.getText().equals(""))
				suma += Double.valueOf(tf1.getText());
			if(!tf2.getText().equals(""))
				suma += Double.valueOf(tf2.getText());
			if(!tf3.getText().equals(""))
				suma += Double.valueOf(tf3.getText());
		}
		tf4.setText(suma + "");
	}
	
	public String getText1() {
		return tf1.getText();
	}
	
	public String getText2() {
		return tf2.getText();
	}
	
	public String getText3() {
		return tf3.getText();
	}
	
	public String getText4() {
		return tf4.getText();
	}
	
}
