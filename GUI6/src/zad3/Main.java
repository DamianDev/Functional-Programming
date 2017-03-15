package zad3;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;

public class Main extends JFrame{

	static JCheckBox wiersz = new JCheckBox("Wierszy");
	static JCheckBox podatek = new JCheckBox("Podatku");
	PrzychodyPanel przychod = new PrzychodyPanel(wiersz, podatek, "Przychód");
	KupPanel kosztUzyskaniaWProcentach = new KupPanel(wiersz, podatek, "Koszty uzysakania w %");
	KuPanel kosztUzyskaniaPrzychodu = new KuPanel(wiersz, podatek, "Koszty uzyskania przychodu", przychod, kosztUzyskaniaWProcentach);
	DochodyPanel dochod = new DochodyPanel(wiersz, podatek, "Dochód", przychod, kosztUzyskaniaPrzychodu);
	ZaliczkiPanel zaliczki = new ZaliczkiPanel(wiersz, podatek, "Zaliczki");
	Management mg = new Management(przychod, kosztUzyskaniaWProcentach, kosztUzyskaniaPrzychodu, dochod, zaliczki);
	
	//Definicje
	JPanel mainPanel = new JPanel();
	JPanel topPanel = new JPanel();
	JPanel bottomPanel = new JPanel();
	JPanel taxPanel = new JPanel();
	static JLabel kwota = new JLabel("", SwingConstants.RIGHT);
	JPanel choicePanel = new JPanel();
	JPanel checkBoxPanel = new JPanel();
	static JLabel infoLabel = new JLabel("");
	
	public Main() {
		this.setSize(new Dimension(700,300));
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		mainPanel.setLayout(new BorderLayout());
		// Dodawanie paneli w topPanel
		
		
		
		topPanel.add(przychod);
		topPanel.add(kosztUzyskaniaWProcentach);
		topPanel.add(kosztUzyskaniaPrzychodu);
		topPanel.add(dochod);
		topPanel.add(zaliczki);
		
		// Koniec
		
		bottomPanel.setLayout(new GridLayout(0, 1));
		
		JPanel functionalPanel = new JPanel(); // Deklaracja **************
		
		//Przycisk
		JButton b = new JButton("Oblicz");
		b.addActionListener(e -> buttonOnClick());
		functionalPanel.add(b);
		
		//Wyswietlanie kwoty
		
		JLabel label = new JLabel("Wyliczony podatek", SwingConstants.LEFT);
		
		taxPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
		
		taxPanel.setLayout(new GridLayout(0,1));
		taxPanel.add(label);
		taxPanel.add(kwota);
		
		functionalPanel.add(taxPanel);
		
		//CheckBox'y
		
		choicePanel.setLayout(new GridLayout(0, 1));
		
		choicePanel.setBorder(BorderFactory.createMatteBorder(1 , 1, 1, 1, Color.gray));
		
		JLabel autoLabel = new JLabel("Automatyczna przeliczenia");
		
		checkBoxPanel.setLayout(new GridLayout(1, 0));
		
		checkBoxPanel.add(wiersz);
		checkBoxPanel.add(podatek);
		
		choicePanel.add(autoLabel);
		choicePanel.add(checkBoxPanel);
		
		functionalPanel.add(choicePanel);		

		bottomPanel.add(functionalPanel);
		bottomPanel.add(infoLabel);
		
		topPanel.setLayout(new FlowLayout());
		
		mainPanel.add(topPanel, "Center");
		mainPanel.add(bottomPanel, "South");
		
		this.add(mainPanel);
		this.setVisible(true);
	}
	
	public static boolean wierszSelected() {
		return wiersz.isSelected();
	}
	
	public static boolean podatekSelected() {
		return podatek.isSelected();
	}


	private void buttonOnClick() {
		Management.fillAll();
		zaliczki.sumUp();
		kwota.setText(((Double.valueOf(dochod.getText4())*0.15) - Double.valueOf(zaliczki.getText4())) + "");
	}

	

	public static void main(String[] args) {
		new Main();
	}
}
