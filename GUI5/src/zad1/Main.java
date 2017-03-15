package zad1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.*;

public class Main extends JFrame{
	
	JPanel panel = new JPanel() {

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.blue);
			g.drawLine(0, 0, this.getWidth()-1, this.getHeight()-1);
			g.drawLine(0, this.getHeight()-1, this.getWidth()-1, 0);
		}
		
	};
	
	public Main() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(new Dimension(500,500));
		this.setVisible(true);
		this.add(panel);
	}
	
	public static void main(String[] args) {
		Main m = new Main();
	}
}
