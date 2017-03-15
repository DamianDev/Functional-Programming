package zad3;

import java.io.BufferedReader;
import java.io.FileReader;

public class A implements Runnable{
	private Factory factory;
	
	public A(Factory factory) {
		this.factory = factory;
	}
	
	@Override
	public void run() {
	
		try(BufferedReader br = new BufferedReader(new FileReader("../Towary.txt"))) {
			
			String line;
			String[] content;
			int count = 0;
			
			while((line = br.readLine()) != null) {
				count++;
				content = line.split("\\s+");
				
				if(count % 200 == 0)
					System.out.println("Utworzono " + count + " obiektów");
				
				factory.giveProduct(new Product(Integer.valueOf(content[0]),Double.valueOf(content[1])));
				
			}
			factory.finish();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
