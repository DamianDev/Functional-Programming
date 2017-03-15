package zad1;

import javax.swing.*;

public class Main extends JFrame{

	public Main() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(300, 300);
		
		JList list = new JList(new MyListModel());
		
		JScrollPane jsp = new JScrollPane(list);
		
		this.add(jsp);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		  
		new Main();
		  
	}
}
