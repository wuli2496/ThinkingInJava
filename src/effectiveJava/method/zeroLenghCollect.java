package effectiveJava.method;

import java.util.Arrays;
import java.util.List;

public class zeroLenghCollect {
	private final List<Cheese> cheeses = Arrays.asList(new Cheese());
	
	private static final Cheese[] EMPTY_CHEESES = new Cheese[0];
	
	public Cheese[] geCheeses() {
		return cheeses.toArray(EMPTY_CHEESES);
	}
}
