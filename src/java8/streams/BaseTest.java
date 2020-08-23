package java8.streams;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;

public class BaseTest {
	protected List<Dish> menu;
	protected Trader raoul;
	protected Trader mario;
	protected Trader alan;
	protected Trader brian;
	protected List<Transaction> trasactions;
	
	@Before
	public void initBase() {
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
		
		raoul = new Trader("Raoul", "Cambridge");
		mario = new Trader("Mario", "Milan");
		alan = new Trader("Alan", "Cambridge");
		brian = new Trader("Brian", "Cambridge");
		
		trasactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012,  1000),
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950));
	}
}
