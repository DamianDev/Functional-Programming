package zad3;

public class Management {

	static PrzychodyPanel przychody;
	static KupPanel kupPanel;
	static KuPanel kuPanel;
	static DochodyPanel dochody;
	static ZaliczkiPanel zaliczki;
	
	public Management(PrzychodyPanel przychody, KupPanel kupPanel, KuPanel kuPanel, DochodyPanel dochody, ZaliczkiPanel zaliczki) {
		this.przychody = przychody;
		this.kupPanel = kupPanel;
		this.kuPanel = kuPanel;
		this.dochody = dochody;
		this.zaliczki = zaliczki;
	}
	
	public static void fillAll() {
		CalcPanel[] arr = {przychody, kupPanel, kuPanel, dochody, zaliczki};
		for(CalcPanel cp : arr) {
			if(cp instanceof DochodyPanel) {
				dochody.count1();
				dochody.count2();
				dochody.count3();
			}
			if(cp instanceof KuPanel) {
				kuPanel.count1();
				kuPanel.count2();
				kuPanel.count3();
			}
			if(cp.tf1.getText().equals(""))
				cp.tf1.setText("0.0");
			if(cp.tf2.getText().equals(""))
				cp.tf2.setText("0.0");
			if(cp.tf3.getText().equals(""))
				cp.tf3.setText("0.0");
			cp.sumUp();
		}
	}
	
	public static void fillLine(int line) {
		CalcPanel[] arr = {przychody, kupPanel, kuPanel, dochody, zaliczki};
		for(CalcPanel cp : arr) {
			switch(line) {
			case 1:
				if(cp instanceof DochodyPanel)
					dochody.count1();
				if(cp instanceof KuPanel)
					kuPanel.count1();
				if(cp.tf1.getText().equals(""))
					cp.tf1.setText("0.0");
				break;
				
			case 2:
				if(cp instanceof DochodyPanel)
					dochody.count2();
				if(cp instanceof KuPanel)
					kuPanel.count2();
				if(cp.tf2.getText().equals(""))
					cp.tf2.setText("0.0");
				break;
				
			case 3:
				if(cp instanceof DochodyPanel)
					dochody.count3();
				if(cp instanceof KuPanel)
					kuPanel.count3();
				if(cp.tf3.getText().equals(""))
					cp.tf3.setText("0.0");
				break;
			}
	}
	}
	public static void autoFill() {
		Management.fillAll();
		//zaliczki.sumUp();
		Main.kwota.setText(((Double.valueOf(dochody.getText4())*0.15) - Double.valueOf(zaliczki.getText4())) + "");
	}
}
