/**
 *
 *  @author Kalicki Damian S13828
 *
 */

package zad4;


public abstract class Spiewak {
	
	private String name;
	private int id;
	public static int qty = 0;
	
	public Spiewak(String name) {
		this.name = name;
		id = ++qty;
	}
	
	@Override
	public String toString() {
		return "("+id+") " + this.name + ": " + this.spiewaj();
	}
	
	public static Spiewak najglosniej(Spiewak[] tab) {
		Spiewak najglosniejszy = null;
		int count = 0;
		int max = 0;
		
		for(Spiewak s : tab) {
			count = 0;
			
			for(int i = 0; i < s.spiewaj().length(); i++) {
				if(s.spiewaj().charAt(i) >= 'A' && s.spiewaj().charAt(i) <= 'Z')
					count++;
			}
			
			if(count > max) {
				max = count;
				najglosniejszy = s;
			}
				
		}
		
		return najglosniejszy;
	}
	
	
	abstract String spiewaj();
	
}
