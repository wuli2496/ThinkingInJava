package effectiveJava.test;

import org.junit.Test;

import effectiveJava.enumAndAnotaton.Operation;
import effectiveJava.enumAndAnotaton.Planet;

public class EffectiveJavaTest {

	@Test
	public void testEnum() {
		double earchWeight = 100;
		double mass = earchWeight / Planet.EARTH.surfaceGravity();
		for (Planet p : Planet.values()) {
			System.out.printf("Weight on %s is %f%n", p, p.surfaceWeight(mass));
		}
	}
	
	@Test
	public void testOperatonEnum() {
		double x = 2.00000;
		double y = 4.00000;
		
		for (Operation operation : Operation.values()) {
			System.out.printf("%f %s %f = %f%n", x, operation, y, operation.apply(x,  y));
		}
	}
}
