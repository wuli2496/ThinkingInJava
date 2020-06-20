package java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

import static java.util.stream.Collectors.toList;

public class streamsTest {
	private List<Dish> menu;
	
	@Before
	public void init()
	{
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
	}
	
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
}
