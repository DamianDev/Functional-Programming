package zad2;

import java.util.HashMap;
import java.util.Map;

public class PriceList {
	
	private static PriceList priceList = new PriceList();
	private Map<String,Double> map = new HashMap<>();
	
	public static PriceList getInstance() {
		return priceList;
	}
	
	public void put(String name, double price) {
		if(!map.containsKey(name))
			map.put(name, price);
	}
	
	public double amount(Flower flower) {
		if(map.containsKey(flower.getName()))
			return flower.getQty()*map.get(flower.getName());
		else 
			return -1;
	}
	
	public double getPrice(Flower f) {
		if(map.containsKey(f.getName()))
			return map.get(f.getName());
		else
			return -1;
	}
}
