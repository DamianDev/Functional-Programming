/**
 *
 *  @author Kalicki Damian S13828
 *
 */

package zad4;


public class Writer implements Runnable {

	private Author author;
	
	public Writer(Author author) {
		this.author = author;
	}

	@Override
	public void run() {
		
		while(true) {
			String txt = author.takeText();
			
			if(txt == null) {
				//System.out.println("Otrzymałem null, koniec wątku Writer");
				return;
			}
			
			System.out.println(txt);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				return;
			}
		}
	}
}
