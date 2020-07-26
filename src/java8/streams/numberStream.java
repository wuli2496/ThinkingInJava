package java8.streams;

import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class numberStream extends BaseTest{
	private int actual;
	
	@Before
	public void init() {
		
		for (Dish dish : menu) {
			actual += dish.getCalories();
		}
	}
	
	@Test
	public void testNoNumberStream() {
		int categories = menu.stream().map(Dish::getCalories).reduce(0, Integer::sum);
		
		Assert.assertEquals(categories, actual);
	}	
	
	@Test
	public void testIntStream() {
		int categories = menu.stream().mapToInt(Dish::getCalories).sum();
		
		Assert.assertEquals(categories, actual);
	}
	
	@Test
	public void testConvertToObjectStream() {
		IntStream intStream = menu.stream().mapToInt(Dish::getCalories);
		Stream<Integer> stream = intStream.boxed(); 
		stream.forEach(System.out::println);
	}
	
	@Test
	public void testStreamOptionalInt() {
		OptionalInt maxCalories = menu.stream().mapToInt(Dish::getCalories).max();
		System.out.println(maxCalories);
	}
	
	@Test
	public void testNumberStreamRangeClosed() {
		IntStream intStream = IntStream.rangeClosed(1,  100).filter(n -> n % 2 == 0);
		System.out.println(intStream.count());
	}
	
	@Test
	public void testPythagoreanTriples() {
		Stream<int[]> pythagoreanTriple = IntStream.rangeClosed(1,  100).boxed()
													.flatMap(a -> 
														IntStream.rangeClosed(a, 100).filter(b ->
														Math.sqrt(a * a + b * b) % 1 == 0).mapToObj(b ->
														new int[] {a, b, (int)Math.sqrt(a * a + b * b)}));
		pythagoreanTriple.limit(5).forEach(t -> System.out.println(t[0] + "," + t[1] + "," + t[2]));
	}
	
	@Test
	public void testPythagoreanTriples2() {
		Stream<double[]> pythagoreanTriple = IntStream.rangeClosed(1,  100).boxed()
				.flatMap(a -> IntStream.rangeClosed(a, 100)
						.mapToObj(b -> new double[] {a, b, Math.sqrt(a * a + b * b)})
						.filter(t -> t[2] % 1 == 0));
		pythagoreanTriple.limit(5).forEach(t -> System.out.println(t[0] + "," + t[1] + "," + t[2]));
	}
}
