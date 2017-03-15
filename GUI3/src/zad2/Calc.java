/**
 *
 *  @author Kalicki Damian S13828
 *
 */

package zad2;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Calc {
	
	public String doCalc(String input) {
		
		String result;
		Map<String, Calculation> map = new HashMap<>();
		
		map.put("+", new Adding());
		map.put("-", new Substraction());
		map.put("*", new Multiplication());
		map.put("/", new Division());
		
		String[] inputArr = input.split("\\s+");
		
		try {
			
			result = map.get(inputArr[1]).calculate(new BigDecimal(inputArr[0]), new BigDecimal(inputArr[2]));
			
		} catch(Exception e) {
			
			return "Invalid command to calc";
		}
		
		return result;
	}
	
}  
