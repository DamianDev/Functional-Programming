package zad2;

public abstract class Flower {
	
	private int qty;
	
	public Flower(int qty) {
		this.qty = qty;
	}
	
	public int getQty() {
		return qty;
	}
	
	@Override
	public String toString() {
		return getName() + ", kolor: " + getColor() + ", ilość: " + qty + ", cena: " + PriceList.getInstance().amount(this);
	}
	
	abstract String getName();
	
	abstract String getColor();
}
