package java8.streams;

import org.junit.Test;


import static java.util.stream.Collectors.*;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamCollect extends BaseTest {

	@Test
	public void testCollectCount() {
		long count = menu.stream().collect(Collectors.counting());
		System.out.println(count);
	}
	
	@Test
	public void testCollectCount2() {
		System.out.println(menu.stream().count());
	}
	
	@Test
	public void testCollectMaxBy() {
		Comparator<Dish> dishCalorieComparator = Comparator.comparing(Dish::getCalories);
		Optional<Dish> mostCalorieDish = menu.stream().collect(maxBy(dishCalorieComparator));
		System.out.println(mostCalorieDish);
	}
	
	@Test
	public void testCollectSumming() {
		int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
		System.out.println(totalCalories);
	}
	
	@Test
	public void testCollectAveraging() {
		double averCalories = menu.stream().collect(averagingInt(Dish::getCalories));
		System.out.println(averCalories);
	}
	
	@Test
	public void testCollectJoin() {
		String anString = menu.stream().map(Dish::getName).collect(joining(","));
		System.out.println(anString);
	}
	
	@Test
	public void testCollectGroup() {
		Map<Dish.Type, List<Dish>> dishByType = menu.stream().collect(groupingBy(Dish::getType));
		System.out.println(dishByType);
	}
	
	@Test
	public void tetCollectGroupByCustomFunction() {
		Map<CaloricLevel, List<Dish>> dishByCaloricLevel = menu.stream()
				.collect(groupingBy(dish -> {
					if (dish.getCalories() <= 400) {
						return CaloricLevel.DIET;
					} else if (dish.getCalories() <= 700) {
						return CaloricLevel.NORMAL;
					} else {
						return CaloricLevel.FAT;
					}
				}));
		System.out.println(dishByCaloricLevel);
	}
	
	@Test
	public void testCollectGourpByMoreTwo() {
		Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishByTypeAndCaloryLevel = menu.stream()
				.collect(groupingBy(Dish::getType, groupingBy(dish -> {
					if (dish.getCalories() <= 400) {
						return CaloricLevel.DIET;
					} else if (dish.getCalories() <= 700) {
						return CaloricLevel.NORMAL;
					} else  {
						return CaloricLevel.FAT;
					}
				})));
		System.out.println(dishByTypeAndCaloryLevel);
	}
	
	@Test
	public void testCollectGroupByCounting() {
		Map<Dish.Type, Long> typeCount = menu.stream().collect(groupingBy(Dish::getType, counting()));
		System.out.println(typeCount);
	}
	
	@Test
	public void testCollectGroupByMaxBy() {
		Map<Dish.Type, Optional<Dish>> mostCaloricByType = menu.stream()
				.collect(groupingBy(Dish::getType, maxBy(Comparator.comparing(Dish::getCalories))));
		System.out.println(mostCaloricByType);
	}
	
	@Test
	public void testCollectingAndThen() {
		Map<Dish.Type, Dish> mostCaloryByType = menu.stream()
				.collect(groupingBy(Dish::getType, collectingAndThen(maxBy(Comparator.comparing(Dish::getCalories)), Optional::get)));
		System.out.println(mostCaloryByType);
	}
	
	@Test
	public void testCollectGroupingByAndSummingInt() {
		Map<Dish.Type, Integer> totalCaloriesByType = menu.stream()
				.collect(groupingBy(Dish::getType, summingInt(Dish::getCalories)));
		System.out.println(totalCaloriesByType);
	}
	
	@Test
	public void testCollectGroupingByAndMapping() {
		Map<Dish.Type, Set<CaloricLevel>> caloryLevelByType = menu.stream()
				.collect(groupingBy(Dish::getType, mapping(dish ->
				{
					if (dish.getCalories() <= 400) {
						return CaloricLevel.DIET;
					} else if (dish.getCalories() <= 700) {
						return CaloricLevel.NORMAL;
					} else {
						return CaloricLevel.FAT;
					}
				}, toSet())));
		System.out.println(caloryLevelByType);
	}
	
	@Test
	public void testCollectGroupingByAndMappingAndToCollection() {
		Map<Dish.Type, Set<CaloricLevel>> caloryLevelByType = menu.stream()
				.collect(groupingBy(Dish::getType, mapping(dish ->
				{
					if (dish.getCalories() <= 400) {
						return CaloricLevel.DIET;
					} else if (dish.getCalories() <= 700) {
						return CaloricLevel.NORMAL;
					} else {
						return CaloricLevel.FAT;
					}
				}, toCollection(HashSet::new))));
		System.out.println(caloryLevelByType);
	}
}
