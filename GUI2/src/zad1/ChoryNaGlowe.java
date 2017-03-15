package zad1;

public class ChoryNaGlowe extends Pacjent {

	public ChoryNaGlowe(String imie) {
		super(imie);
	}
	
	public String choroba() {
		return "głowa";
	}
	
	public String leczenie() {
		return "aspiryna";
	}
}
