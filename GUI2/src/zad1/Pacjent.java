package zad1;

public abstract class Pacjent {
	
	private String imie;
	
	public Pacjent(String imie){
		this.imie = imie;
	}
	
	public String nazwisko() {
		return imie;
	}
	
	abstract String choroba();
	
	abstract String leczenie();
}
