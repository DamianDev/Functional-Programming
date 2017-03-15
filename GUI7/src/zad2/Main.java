package zad2;

import java.awt.BorderLayout;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class Main extends JFrame{

	Object[] test = {"a", "b", "c", "d"};
	DefaultListModel<String> lm = new DefaultListModel<>();
	JList<String> list = new JList<>(lm);
	JScrollPane jsp = new JScrollPane(list);
	JTextField tf = new JTextField();
	JPanel panel = new JPanel();
	boolean altClicked = false;
	
	public Main() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(600, 600);
		
		tf.addActionListener(e -> enterPressed());
		
		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(altClicked)
					if(list.getSelectedIndex() != -1)
						lm.remove(list.getSelectedIndex());
			}
		});
		
		list.addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent e) {
				if(e.isAltDown())
					altClicked = true;
				else
					altClicked = false;
			}
			
			public void keyReleased(KeyEvent e) {
				if(!e.isAltDown())
					altClicked = false;
			}
		});
		
		panel.setLayout(new BorderLayout());
		
		panel.add(jsp, "Center");
		
		panel.add(tf, "South");
		
		this.add(panel);
		this.setVisible(true);
	}
	
	private void enterPressed() {
		lm.addElement(tf.getText());
		tf.setText("");
	}

	public static void main(String[] args) {
		new Main();
	}
}
