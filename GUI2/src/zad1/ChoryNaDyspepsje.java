package zad1;

public class ChoryNaDyspepsje extends Pacjent{

	public ChoryNaDyspepsje(String imie) {
		super(imie);
	}
	
	public String choroba () {
		return "dyspepsja";
	}
	
	public String leczenie() {
		return "węgiel";
	}
}
