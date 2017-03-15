package zad3;


public class Main {
	public static void main(String[] args) {
	  
		Factory factory = new Factory();
		
		Thread a = new Thread(new A(factory));
		Thread b = new Thread(new B(factory));
	  
		a.start();
		b.start();
		
	}
}
