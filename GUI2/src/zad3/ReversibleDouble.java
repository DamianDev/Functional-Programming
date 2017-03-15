package zad3;

public class ReversibleDouble implements Reversible{

	private double number;
	
	public ReversibleDouble(double number) {
		this.number = number;
	}
	
	public Reversible reverse() {
		number = 1/number;
		return this;
	}
	
	public double getNumber() {
		return number;
	}
	
	@Override
	public String toString() {
		return "" + number;
	}
}
