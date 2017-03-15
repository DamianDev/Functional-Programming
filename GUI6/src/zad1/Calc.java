/**
 *
 *  @author Kalicki Damian S13828
 *
 */

package zad1;


public class Calc {
	
	private double x,y,result;
	private Operation op;

	public double add(double i, double j) {
		x = i;
		y = j;
		op = Operation.ADD;
		result = i + j;
		return result;
	}

	public double substract(double d, double e) {
		x = d;
		y = e;
		op = Operation.REM;
		result = d - e;
		return result;
	}

	public double multiply(double i, double d) {
		x = i;
		y = d;
		op = Operation.MUL;
		result = i * d;
		return result;
	}

	public double divide(double l1, double d) {
		x = l1;
		y = d;
		op = Operation.DIV;
		if(d != 0)
			result = l1 / d;
		else
			return Double.NaN;
		return result;
	}
	
	@Override
	public String toString() {
		if(op == Operation.DIV && y == 0)
			return x + " " + op.getDescription() + " " + y + " = " + "ERR";
		else
			return x + " " + op.getDescription() + " " + y + " = " + result;
		
	}
	
}  
