package zad2;

import java.math.BigDecimal;
import java.math.MathContext;

public class Division implements Calculation {

	@Override
	public String calculate(BigDecimal arg1, BigDecimal arg2) throws Exception {
		BigDecimal result = null;
		
		try {
			
			result = arg1.divide(arg2, MathContext.DECIMAL64);
			
		}catch(Exception e) {
			
			throw new Exception();
			
		}
		return result.toString();
	}

}
