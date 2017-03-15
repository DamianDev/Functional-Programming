package zad3;


public class B implements Runnable{
	private Factory factory;
	
	public B(Factory factory) {
		this.factory = factory;
	}
	
	@Override
	public void run() {
		
		Product p = null;
		int count = 0;
		
		while(true) {
			
			p = factory.takeProduct();
			
			if(p.equals(factory.poisonPill())) {
				System.out.println("Waga: " + factory.getWeight().toString());
				return;
			}
				
			count++;
			
			if(count % 100 == 0)
				System.out.println("policzono wage " + count + " towarów");
		}
	}
	
	

}