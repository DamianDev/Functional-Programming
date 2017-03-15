package zad1;

import java.util.Iterator;

public class Hailstone implements Iterable<Integer>{

	private int ini;
	
	public Hailstone(int ini) {
		this.ini = ini;
	}

	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {

			boolean isItFirst = true;
			
			@Override
			public boolean hasNext() {
				if(ini == 1)
					return false;
				else
					return true;
			}

			@Override
			public Integer next() {
				if(isItFirst) {
					isItFirst = false;
					return ini;
				}
				else {
					if(ini % 2 == 0)
						ini /= 2;
					else 
						ini = 3*ini + 1;
					
					return ini;
				}
			}
		};
	}
	
}
