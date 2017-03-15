package zad2;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {

	private static Dimension screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
	private Image img;
	private boolean loaded = false;
	private boolean finished = false;
	private int fontSize;
	
	public ImagePanel() {
		
	}
	
	public ImagePanel(int fontSize) {
		this.fontSize = fontSize;
	}
	
	public void displayImage(String path) {
		
		if(path != null) {
			img = new ImageIcon(path).getImage();
			int width = img.getWidth(this);
			int height = img.getHeight(this);
			
			if(width != -1 && width != 0 && height != -1 && height != 0) {
				
				loaded = true;
				
				if(width > screenDimension.getWidth() || height > screenDimension.getHeight()) {
					
					double proportions = (double)width / height;
					
					if(width > screenDimension.getWidth()) {
						width = screenDimension.width;
						height = (int)(width / proportions);
					}
					if(height > screenDimension.getHeight()) {
						height = screenDimension.height;
						width = (int)(screenDimension.width * proportions);
					}
				}
				
				this.setPreferredSize(new Dimension(width, height));
			}
			else {
				loaded = false;
				this.setPreferredSize(new Dimension(200, 200));
			}
		}
		else {
			this.setPreferredSize(new Dimension(200,200));
			finished = true;
		}
		validate();
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if(finished) {
			g.setFont(new Font("Dialog", Font.PLAIN, fontSize));
			g.drawString("Koniec prezentacji", (getWidth() - g.getFontMetrics().stringWidth("Koniec prezentacji"))/2, (getHeight() - g.getFontMetrics().getHeight())/2);
			return;
		}
		if(img != null && loaded)
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		else {
			g.setFont(new Font("Dialog", Font.PLAIN, fontSize));
			g.drawString("Nie załadowano obrazka", (getWidth() - g.getFontMetrics().stringWidth("Nie załadowano obrazka"))/2, (getHeight() - g.getFontMetrics().getHeight())/2);
		}
	}
}
