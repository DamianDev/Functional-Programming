package zad3;

import java.awt.Color;

import javax.swing.JCheckBox;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;

public class KupPanel extends CalcPanel {

	public KupPanel(JCheckBox w, JCheckBox l, String text) {
		super(w, l, text);
		tf4.enable(false);
		tf4.setEditable(false);
		tf4.setBackground(Color.gray);
		info = "Koszt uzyskania w % ze źródła: ";
		createPopupMenu(tf1);
		createPopupMenu(tf2);
		createPopupMenu(tf3);
	}
	
	public void createPopupMenu(JTextField tf) {
		JPopupMenu pm = new JPopupMenu();
		
		JMenuItem jm;
		
		for(int i = 10; i <= 100; i += 10) {
			int j = i;
			jm = new JMenuItem(i + "");
			jm.addActionListener(e -> tf.setText(j + ""));
			pm.add(jm);
		}
		
		tf.add(pm);
		tf.setComponentPopupMenu(pm);
	}

}
