package zad3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.*;

public class Main extends JFrame{
	
	JTextArea text = new JTextArea();
	JScrollPane jsp = new JScrollPane(text);
	
	public Main() {
		
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(500, 500);
		text.setBackground(Color.blue);
		text.setForeground(Color.yellow);
		text.setFont(new Font(Font.DIALOG, Font.BOLD | Font.ITALIC, 14));
		this.add(jsp);
	}

  public static void main(String[] args) {
	  Main m = new Main();
  }
}
