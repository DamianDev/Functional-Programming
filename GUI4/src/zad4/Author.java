/**
 *
 *  @author Kalicki Damian S13828
 *
 */

package zad4;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class Author implements Runnable {

	private String[] content;
	private BlockingQueue<Text> queue = new SynchronousQueue<>();
	
	public Author(String[] content) {
		this.content = content;
	}
	
	public String takeText() {
		String s = null;
		try {
			s = queue.take().getContent();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public void run() {
	
		for(int i = 0; i < content.length; i++) {
			try	{
				queue.put(new Text(content[i]));
			} catch (InterruptedException e) {
				return;
			}
		}
		try {
			queue.put(new Text(null));
		} catch (InterruptedException e) {
			return;
		}
		//System.out.println("Koniec wątku Author");
	}
}  
