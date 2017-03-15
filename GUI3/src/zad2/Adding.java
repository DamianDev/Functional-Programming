package zad2;

import java.math.BigDecimal;

public class Adding implements Calculation {

	@Override
	public String calculate(BigDecimal arg1, BigDecimal arg2) {
		return arg1.add(arg2).toString();
	}

}
