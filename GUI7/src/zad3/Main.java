package zad3;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Main extends JFrame{
	
	private String path = "D:\\dane";
	private String[] columnNames = {"Autor", "Tytuł", "Cena", "Okładka"};
	private JPanel mainPanel = new JPanel();
	private JPanel bottomPanel = new JPanel();
	private DefaultTableModel tm = new DefaultTableModel(columnNames,0);
	private JTable table = new JTable(tm);
	
	public Main() {
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setSize(600, 600);
		
		table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
		    protected void setValue(Object value) {
		        if( value instanceof ImageIcon ) {
		            setIcon((ImageIcon)value);
		            setText("");
		        } else {
		            setIcon(null);
		            super.setValue(value);
		        }
		    }
		});
		
		mainPanel.setLayout(new BorderLayout());
		fillTable();
		mainPanel.add(new JScrollPane(table));
		mainPanel.add(bottomPanel, "South");
		
		JButton add = new JButton("Dodaj");
		add.addActionListener(e -> tm.addRow(new Object[] {}));
		JButton remove = new JButton("Usuń");
		remove.addActionListener(e -> {
			if(table.getSelectedRow() != -1)
				tm.removeRow(table.getSelectedRow());
		});
		bottomPanel.add(add);
		bottomPanel.add(remove);
		
		this.add(mainPanel);
		this.pack();
		this.setVisible(true);
	}
	
	public void fillTable() {
		List<Book> list = readFile(path);
		
		for(Book b : list) {
			tm.addRow(b.getProperties());
			//Ustawienie wielkości jednego cell'a.
			table.setRowHeight(table.getRowCount()-1, b.getCover().getIconHeight());
			table.getColumnModel().getColumn(3).setPreferredWidth(b.getCover().getIconWidth());
			tm.setValueAt(b.getCover(), table.getRowCount()-1, 3);
		}
	}

	public List<Book> readFile(String path) {
	
		List<Book> result = new ArrayList<>();
		String line;
		String[] arr;
		
		try(BufferedReader br = new BufferedReader(new FileReader(path + "\\dane.txt"))) {
			while((line = br.readLine()) != null) {
				arr = line.split(",");
				if(arr.length == 3)
					result.add(new Book(arr[0], arr[1], arr[2], new ImageIcon(path + "\\" + arr[1].trim() + ".jpg")));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static void main(String[] args) {
	
		new Main();
		
	}
}
