package effectiveJava.enumAndAnotaton;

public enum Operation {
	PLUS("+") {
		public double apply(double x, double y) {
			return x + y;
		}
	},
	MINUS("-") {
		public double apply(double x, double y) {
			return x - y;
		}
	},
	TIMES("*") {
		public double apply(double x, double y) {
			return x * y;
		}
	},
	DIVIDE("/") {
		public double apply(double x, double y) {
			return x / y;
		}
	};
	
	 public abstract double apply(double x, double y);
	/*
	double apply(double x, double y) {
		switch (this) {
		case PLUS: return x + y;
		case MINUS: return x - y;
		case TIMES: return x * y;
		case DIVIDE: return x / y;
		}
		
		throw new AssertionError("Unknown op: " + this);
	}
	*/
	
	private final String symbol;
	
	Operation(String symbol) {
		this.symbol = symbol;
	}
	
	@Override
	public String toString() {
		return symbol;
	}
}
