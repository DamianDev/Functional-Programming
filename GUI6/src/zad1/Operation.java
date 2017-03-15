package zad1;

public enum Operation {
	
	ADD("+"),
	REM("-"),
	MUL("*"),
	DIV("/");
	
	private String description;
	
	private Operation(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return this.description;
	}
}
