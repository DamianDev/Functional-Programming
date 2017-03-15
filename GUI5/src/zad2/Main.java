package zad2;

import java.awt.Dimension;
import java.io.File;
import java.util.Arrays;

import javax.swing.JFrame;

public class Main extends JFrame {

	public Main(String path, int time, int fontSize) {
		ImagePanel panel = new ImagePanel(fontSize);
		File[] images;
		
		try {
				images = Arrays.stream(new File(path).listFiles())
				.filter(t -> t.getName().toLowerCase().endsWith(".jpg")
						|| t.getName().toLowerCase().endsWith(".png")
						|| t.getName().toLowerCase().endsWith(".gif"))
				.toArray(File[]::new);
		} catch(NullPointerException e){
			return;
		}
		
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.add(panel);
		
		for(File f : images) {
			panel.displayImage(f.getPath());
			this.pack();
			this.setTitle(f.getName());
			
			try {
				Thread.sleep(time*1000);
			} catch (InterruptedException e) {
				break;
			}
			
		}
		this.setSize(new Dimension(600,600));
		panel.displayImage(null);
		this.setTitle("Koniec");
	}
	
	public static void main(String[] args) {
		if(args.length > 0)
			new Main(args[0], Integer.valueOf(args[1]), Integer.valueOf(args[2]));
		
	}
}
