package zad3;

public class ReversibleString implements Reversible {
	
	private String napis;
	
	public ReversibleString(String napis) {
		this.napis = napis;
	}
	
	public Reversible reverse() {
		napis = new StringBuilder(napis).reverse().toString();
		return this;
	}

	@Override
	public String toString() {
		return napis;
	}
}
