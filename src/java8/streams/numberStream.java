package java8.streams;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import net.test.chapter11_container.ForEachCollections;

public class numberStream {
	private List<Dish> menu;
	private int actual;
	
	@Before
	public void init() {
		menu = Arrays.asList(
				new Dish("pork", false, 800, Dish.Type.MEAT),
				new Dish("beef", false, 700, Dish.Type.MEAT),
				new Dish("chicken", false, 400, Dish.Type.MEAT),
				new Dish("french fries", true, 530, Dish.Type.OTHER),
				new Dish("rice", true, 350, Dish.Type.OTHER),
				new Dish("season fruit", true, 120, Dish.Type.OTHER),
				new Dish("pizza", true, 550, Dish.Type.OTHER),
				new Dish("prawns", false, 300, Dish.Type.FISH),
				new Dish("salmon", false, 450, Dish.Type.FISH)
				);
		
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
}
