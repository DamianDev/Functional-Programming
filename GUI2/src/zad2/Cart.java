package zad2;

import java.util.ArrayList;
import java.util.List;

public class Cart {

	protected Customer owner;
	protected List<Flower> content = new ArrayList<>();
	
	public Cart(Customer owner) {
		this.owner = owner;
	}
	
	public void replaceContent(List<Flower> list) {
		this.content = list;
	}
	
	public void add(Flower flower) {
		content.add(flower);
	}
	
	public int getShoppingCartSize() {
		return content.size();
	}
	
	public Flower getFlower(int index){
		return content.get(index);
	}
	
	public String getOwner() {
		return owner.getName();
	}
	
	public void putAside(int index) {
		content.remove(index);
	}
	
	public List<Flower> getContent() {
		return content;
	}
	
	public void coreOut() {
		content = new ArrayList<Flower>();
	}
	
	@Override
	public String toString(){
		String result = null;
		if(this instanceof ShoppingCart) {
			if(content.isEmpty()) {
				return " -- pusto";
			}
			else {
				result = "Wózek w³aœciciel " + owner.getName();
				
				for(Flower f : content) {
					result += "\n";
					result += f.getName() + ", kolor: " + f.getColor() + ", iloœæ " + f.getQty() + ", cena " + PriceList.getInstance().getPrice(f);
				}
			}
		}
		else if(this instanceof Box) {
			
			result = "Pude³ko w³aœciciel " + owner.getName();
			
			for(Flower f : content){
				result += "\n";
				result += f.getName() + ", kolor: " + f.getColor() + ", iloœæ " + f.getQty() + ", cena " + PriceList.getInstance().getPrice(f);
			}
		}
		return result;
	}
	
}
