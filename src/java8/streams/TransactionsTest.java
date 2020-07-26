package java8.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.Test;

public class TransactionsTest extends BaseTest {
	/*
	 * 找出2011年发生的所有交易，并按交易额排序（从低到高）
	 */
	@Test
	public void testTrader2011Sort() {
		List<Transaction> tr2011 = trasactions.stream().filter(transaction -> transaction.getYear() == 2011)
							.sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());
		tr2011.stream().forEach(System.out::println);
	}
	
	/**
	 * 交易员都在哪些不同的城市工作过
	 */
	@Test
	public void testTraderCity() {
		List<String> cities = trasactions.stream().map(transaction -> transaction.getTrader().getCity()).distinct().collect(Collectors.toList());
		cities.stream().forEach(System.out::println);
	}
	
	/**
	 *  查找所有来自于剑桥的交易员，并按姓名排序
	 */
	@Test
	public void testTraderFromCambridgeSortName() {
		List<Trader> traders = trasactions.stream().map(Transaction::getTrader)
										  .filter(trader -> trader.getCity().equals("Cambridge"))
										  .distinct()
										  .sorted(Comparator.comparing(Trader::getName))
										  .collect(Collectors.toList());
		traders.stream().forEach(System.out::println);
	}
	
	/**
	 * 返回所有交易员的姓名字符串，按字母顺序排序
	 */
	@Test
	public void testTraderNameSort() {
		String anString = trasactions.stream().map(transaction -> transaction.getTrader().getName())
							.distinct()
							.sorted()
							.collect(Collectors.joining(","));
		System.out.println(anString);
	}
	
	/**
	 * 有没有交易员是在米兰工作的
	 */
	@Test
	public void testMilanWork() {
		boolean exist = trasactions.stream()
								   .anyMatch(transactoin -> transactoin.getTrader().getCity().equals("Milan"));
		System.out.println(exist);
	}
	
	/**
	 * 打印生活在剑桥的交易员的所有交易额
	 */
	@Test
	public void testTraderInCambridgeAmount() {
		trasactions.stream().filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
							.map(Transaction::getValue)
							.forEach(System.out::println);
	}
	
	/**
	 * 所有交易中，最高的交易额是多少
	 */
	@Test
	public void testMaxTraderValue() {
		Optional<Integer> highestValue = trasactions.stream().map(Transaction::getValue).reduce(Integer::max);
		System.out.println(highestValue);
	}
	
	/**
	 * 找到交易额最小的交易
	 */
	@Test
	public void testMinTrader() {
		Optional<Transaction> optional = trasactions.stream().reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);
		System.out.println(optional);
		
	}
}
