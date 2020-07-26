package java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

import static java.util.stream.Collectors.toList;

public class streamsTest extends BaseTest{

	@Test
	public void testFilter()
	{
		List<String> threeHighCaloricDishNames = menu.stream().
				filter(d -> d.getCalories() > 300).map(Dish::getName).limit(3).collect(toList());
		threeHighCaloricDishNames.stream().forEach(System.out::println);
			
	}
	
	@Test
	public void testTwoConsumeStream()
	{
		List<String> title = Arrays.asList("Java8", "In", "Action");
		Stream<String> stream = title.stream();
		stream.forEach(System.out::println);
		//stream.forEach(System.out::println);
	}
	
	@Test
	public void testFilterVegetarian()
	{
		List<Dish> vegetarianDishesDishs = menu.stream()
				.filter(Dish::isVegetarian)
				.collect(toList());
		vegetarianDishesDishs.stream().forEach(System.out::println);
	}
	
	@Test
	public void testDistinct()
	{
		List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
		numbers.stream()
				.filter(i -> i % 2 == 0)
				.distinct()
				.forEach(System.out::println);
	}
	
	@Test
	public void testLimit()
	{
		List<Dish> dishes = menu.stream()
								.filter(d -> d.getCalories() > 300)
								.limit(3)
								.collect(toList());
		dishes.stream().forEach(System.out::println);
	}
	
	@Test
	public void testSkip()
	{
		List<Dish> dishes = menu.stream()
								.filter(d -> d.getCalories() > 300)
								.skip(2)
								.collect(toList());
		dishes.stream().forEach(System.out::println);
	}
	
	@Test
	public void testFlatMap()
	{
		List<String> words = Arrays.asList("Hello", "World");
		List<String> anStrings = words.stream()
									.map(word -> word.split(""))
									.flatMap(Arrays::stream)
									.distinct()
									.collect(toList());
		
		for (String string : anStrings) {
			System.out.println(string);
		}
		
	}
	
	@Test
	public void testReduceSum() {
		List<Integer> numbers = Arrays.asList(1, 2, 3);
		int ans = numbers.stream().reduce(0, (a, b) -> a + b);
		Assert.assertEquals(ans, 6);
	}
	
	@Test
	public void testReduceMax() {
		List<Integer> numbers = Arrays.asList(1, 2, 3);
		Optional<Integer> ans = numbers.stream().reduce(Integer::max);
		ans.ifPresent(System.out::println);
	}

	@Test
	public void testNumberStream() {
		Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1, 100).boxed()
				.flatMap(a ->
						IntStream.rangeClosed(a, 100).filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
						.mapToObj(b -> new int[]{a, b, (int)Math.sqrt(a * a + b * b)})
				);

		pythagoreanTriples.limit(5).forEach(t -> System.out.println(t[0] + "," + t[1] + "," +t[2]));
	}

}
