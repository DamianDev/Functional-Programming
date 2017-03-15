package zad4;

import javax.swing.JOptionPane;

import java.awt.*;

import javax.swing.*;

public class Main extends JFrame{
	
	JPanel panel = new JPanel();
	
	JButton[] buttons = {
			new JButton("Przycisk 1"),
			new JButton("P 2"),
			new JButton("Większy przycisk numer 3"),
			new JButton("Przycisk 4"),
			new JButton("P5")
	};
	
	String[] borders = {"North", "East", "South", "West", "Center"};
	
	
	public Main(String option) {
		
		boolean correctInput = true;
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(500,500);
		
		switch(option.toUpperCase()) {
		//BorderLayout
		case "A":
			panel.setLayout(new BorderLayout());
			for(int i = 0; i < buttons.length; i++)
				panel.add(buttons[i], borders[i]);
			break;
		//FlowLayout Default(Center)
		case "B":
			panel.setLayout(new FlowLayout());
			for(JButton b : buttons)
				panel.add(b);
			break;
		//FlowLayout Left Aligned
		case "C":
			panel.setLayout(new FlowLayout(FlowLayout.LEFT));
			for(JButton b : buttons)
				panel.add(b);
			break;
		//FlowLayout Right Aligned
		case "D":
			panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
			for(JButton b : buttons)
				panel.add(b);
			break;
		//GridLayout 1 row
		case "E":
			panel.setLayout(new GridLayout(1,0));
			for(JButton b : buttons)
				panel.add(b);
			break;
		//GridLayout 1 column
		case "F":
			panel.setLayout(new GridLayout(0,1));
			for(JButton b : buttons)
				panel.add(b);
			break;
		//GridLayout 3,2 table
		case "G":
			panel.setLayout(new GridLayout(3,2));
			for(JButton b : buttons)
				panel.add(b);
			break;
			
		default:
			correctInput = false;
			JOptionPane.showMessageDialog(null, "Podałeś złe dane wejściowe. Należało podać literę od A do G");
			break;
				
		}
		if(correctInput)
			this.setVisible(true);
		this.add(panel);
		//this.pack();
	}
	
	

  public static void main(String[] args) {
	  
	  String option = "";
	  
	  //Zadbać o prawidłowe dane!
	  option = JOptionPane.showInputDialog("Podaj literę od A do G: ");
	  
	  Main m = new Main(option);
	  
  }
}
