package zad2;

import java.math.BigDecimal;

public class Substraction implements Calculation {

	@Override
	public String calculate(BigDecimal arg1, BigDecimal arg2) {
		return arg1.subtract(arg2).toString();
	}

}
