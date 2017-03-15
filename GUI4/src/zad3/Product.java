package zad3;

public class Product {

	private int id;
	private double weight;
	
	public Product(){
		
	}
	
	public Product(int id, double weight) {
		this.id = id;
		this.weight = weight;
	}

	public double getWeight() {
		return weight;
	}
	
	public int getId() {
		return id;
	}
	
}
