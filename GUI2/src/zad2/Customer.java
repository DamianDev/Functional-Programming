package zad2;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	
	private String name;
	private double cash;
	private ShoppingCart shoppingCart = new ShoppingCart(this);
	private PriceList priceList = PriceList.getInstance();
	
	public Customer(String name, double cash) {
		this.name = name;
		this.cash = cash;
	}
	
	public void get(Flower flower) {
		shoppingCart.add(flower);
	}
	
	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}
	
	/*
	
		public void pay() {
		for(int i = 0; i < shoppingCart.getShoppingCartSize(); i++) {
			if(priceList.amount(shoppingCart.getFlower(i)) != -1) {
				if(cash - priceList.amount(shoppingCart.getFlower(i)) >= 0)
					cash -= priceList.amount(shoppingCart.getFlower(i));
				else
					shoppingCart.putAside(i);
			}
			else
				shoppingCart.putAside(i);
		}
	}
	
	*/
	
	public void pay() {
		
		List<Flower> temp = new ArrayList<>();
		
		for(int i = 0; i < shoppingCart.getShoppingCartSize(); i++) {
			if(priceList.getPrice(shoppingCart.getFlower(i)) != -1 && cash - priceList.amount(shoppingCart.getFlower(i)) >= 0) {
				cash -= priceList.amount(shoppingCart.getFlower(i));
				temp.add(shoppingCart.getFlower(i));
			}
		}
		shoppingCart.replaceContent(temp);
	}
	
	public double getCash() {
		return cash;
	}
	
	public void pack(Box box) {
		box.replaceContent(shoppingCart.getContent());
		shoppingCart.coreOut();
	}
	
	public String getName(){
		return this.name;
	}
}
