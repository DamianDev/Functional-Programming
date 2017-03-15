package zad1;

public class CelciusCalculator {
	
	public CelciusCalculator() {}
	
	public double getFahrenheit(int i) {
		return (double)(i * 9 / 5) +32;
	}

	public Object getResult(int i) {
		return i + " stopni C = " + getFahrenheit(i) + " stopni F";
	}
}
