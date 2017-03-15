package zad3;

import java.math.BigDecimal;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class Factory {
	
	private BlockingQueue<Product> queue = new SynchronousQueue<>();
	private BigDecimal weight = new BigDecimal("0");
	private static final Product POISON_PILL = new Product();
	
	public Product poisonPill() {
		return POISON_PILL;
	}
	
	public void giveProduct(Product p) {
				
				try {
					
						queue.put(p);
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
	}
	
	public Product takeProduct() {
		Product p = null;
		try {
			
			p = queue.take();
			
			if(!p.equals(POISON_PILL)) {
				weight = weight.add(new BigDecimal(p.getWeight()));
			}
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return p;
	}
	
	public BigDecimal getWeight() {
		return weight;
	}
	
	public void finish() {
		try {
			queue.put(POISON_PILL);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}