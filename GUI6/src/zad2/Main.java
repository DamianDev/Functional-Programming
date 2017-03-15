package zad2;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

public class Main extends JFrame{
	
	private JTextArea editor = new JTextArea();
	private JScrollPane jsp = new JScrollPane(editor);
	private static Map<String, String> editOptions = new HashMap<>();
	private FileDialog loadFile = new FileDialog(this, "Wczytaj", FileDialog.LOAD);
	private FileDialog saveFile = new FileDialog(this, "Zapisz", FileDialog.SAVE);
	private String currentlyEditedFile = null;
	
	static {
		editOptions.put("Praca", "adres pracy");
		editOptions.put("Szkoła", "adres szkoły");
		editOptions.put("Dom", "adres domu");
	}
	
	public Main() {
		
		this.setSize(400, 400);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		editor.setFont(new Font(Font.DIALOG, Font.PLAIN, 14));
		loadFile.setDirectory(".");
		
		//File
		JMenu file = new JMenu("File");
		
		JMenuItem open = new JMenuItem("Open");
		open.addActionListener(e -> openOnClick());
		open.setMnemonic('O');
		open.setAccelerator(KeyStroke.getKeyStroke('O', KeyEvent.CTRL_MASK));
		file.add(open);
		
		JMenuItem save = new JMenuItem("Save");
		save.addActionListener(e -> saveOnClick());
		save.setMnemonic('S');
		save.setAccelerator(KeyStroke.getKeyStroke('S', KeyEvent.CTRL_MASK));
		file.add(save);
		
		JMenuItem saveAs = new JMenuItem("Save as ...");
		saveAs.addActionListener(e -> saveAsOnClick());
		saveAs.setMnemonic('A');
		saveAs.setAccelerator(KeyStroke.getKeyStroke('A', KeyEvent.CTRL_MASK));
		file.add(saveAs);
		
		//Separator
		JSeparator sep = new JSeparator();
		sep.setBackground(Color.red);
		file.add(sep);
		
		JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(e -> this.dispose());
		exit.setMnemonic('X');
		exit.setAccelerator(KeyStroke.getKeyStroke('X', KeyEvent.CTRL_MASK));
		file.add(exit);
		
		//Edit
		JMenu edit = new JMenu("Edit");
		JMenu adresy = new JMenu("Adresy");
		createAdressesMenu(adresy);
		edit.add(adresy);
		
		//Option
		JMenu option = new JMenu("Option");
		
		JMenu foreground = new JMenu("Foreground");
		createForegroundMenu(foreground);
		option.add(foreground);
		
		JMenu background = new JMenu("Background");
		createBackgroundMenu(background);
		option.add(background);
		
		JMenu font = new JMenu("Font");
		createFontMenu(font);
		option.add(font);
		
		// Main Manu Bar
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(file);
		menuBar.add(edit);
		menuBar.add(option);
		
		this.setJMenuBar(menuBar);
		this.add(jsp);
		this.setVisible(true);
	}
	
	// onClick methods of buttons + creating menus.
	
	private Color[] colors = {Color.BLUE, Color.YELLOW, Color.ORANGE, Color.RED, Color.WHITE, Color.BLACK, Color.GREEN};
	private String[] colorNames = {"Niebieski", "Żółty", "Pomarańczowy", "Czerwony", "Biały", "Czarny", "Zielony"};
	
	public void createForegroundMenu(JMenu c) {
		
		for(int i = 0; i < colors.length; i++) {
			int j = i;
			JMenuItem mi = new JMenuItem(colorNames[i], new ColorIcon(colors[i]));
			mi.addActionListener(e -> editor.setForeground(colors[j]));
			c.add(mi);
		}
		
	}
	
	public void createBackgroundMenu(JMenu c) {
		
		for(int i = 0; i < colors.length; i++) {
			int j = i;
			JMenuItem mi = new JMenuItem(colorNames[i], new ColorIcon(colors[i]));
			mi.addActionListener(e -> editor.setBackground(colors[j]));
			c.add(mi);
		}
	}
	
	public void createFontMenu(JMenu c) {
		
		for(int i = 8; i <= 24; i = i+2) {
			int j = i;
			JMenuItem mi = new JMenuItem(i + " pts");
			mi.addActionListener(e -> editor.setFont(new Font(Font.DIALOG, Font.PLAIN, j)));
			c.add(mi);
		}
		
	}
	
	public void createAdressesMenu(JMenu c) {
		for(String s : editOptions.keySet()) {
			JMenuItem mi = new JMenuItem(s);
			mi.setMnemonic(s.charAt(0));
			mi.setAccelerator(KeyStroke.getKeyStroke(s.charAt(0), KeyEvent.CTRL_MASK | KeyEvent.SHIFT_MASK));
			mi.addActionListener(e -> editor.insert(editOptions.get(s), editor.getCaretPosition()));
			c.add(mi);
		}
	}
	
	public void openOnClick() {
		loadFile.setVisible(true);
		
		if(loadFile.getFile() != null) {
			this.setTitle("Prosty Edytor - " + loadFile.getDirectory() + loadFile.getFile());
			currentlyEditedFile = loadFile.getDirectory() + loadFile.getFile();
			
			try {
				FileReader reader = new FileReader(currentlyEditedFile);
				editor.read(reader, "Content of File");
				reader.close();
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public void saveOnClick() {
		if(currentlyEditedFile != null) {
			try {
				PrintWriter pw =new PrintWriter(currentlyEditedFile);
				 editor.write(pw);
				 pw.close();
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		else 
			saveAsOnClick();
	}
	
	public void saveAsOnClick() {
		saveFile.setVisible(true);
		
		try {
			PrintWriter pw = new PrintWriter(saveFile.getDirectory() + saveFile.getFile());
			 editor.write(pw);
			 pw.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	
  public static void main(String[] args) {
	  new Main();
  }
}
