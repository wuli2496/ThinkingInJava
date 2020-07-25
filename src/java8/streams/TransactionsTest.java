package java8.streams;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

import net.test.chapter10_innerClasses.InheritInner;

public class TransactionsTest {
	
	Trader raoul;
	Trader mario;
	Trader alan;
	Trader brian;
	List<Transaction> trasactions;
	
	@Before
	public void init() {
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
	
	/*
	 * �ҳ�2011�귢�������н��ף��������׶����򣨴ӵ͵��ߣ�
	 */
	@Test
	public void testTrader2011Sort() {
		List<Transaction> tr2011 = trasactions.stream().filter(transaction -> transaction.getYear() == 2011)
							.sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList());
		tr2011.stream().forEach(System.out::println);
	}
	
	/**
	 * ����Ա������Щ��ͬ�ĳ��й�����
	 */
	@Test
	public void testTraderCity() {
		List<String> cities = trasactions.stream().map(transaction -> transaction.getTrader().getCity()).distinct().collect(Collectors.toList());
		cities.stream().forEach(System.out::println);
	}
	
	/**
	 *  �������������ڽ��ŵĽ���Ա��������������
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
	 * �������н���Ա�������ַ���������ĸ˳������
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
	 * ��û�н���Ա��������������
	 */
	@Test
	public void testMilanWork() {
		boolean exist = trasactions.stream()
								   .anyMatch(transactoin -> transactoin.getTrader().getCity().equals("Milan"));
		System.out.println(exist);
	}
	
	/**
	 * ��ӡ�����ڽ��ŵĽ���Ա�����н��׶�
	 */
	@Test
	public void testTraderInCambridgeAmount() {
		trasactions.stream().filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
							.map(Transaction::getValue)
							.forEach(System.out::println);
	}
	
	/**
	 * ���н����У���ߵĽ��׶��Ƕ���
	 */
	@Test
	public void testMaxTraderValue() {
		Optional<Integer> highestValue = trasactions.stream().map(Transaction::getValue).reduce(Integer::max);
		System.out.println(highestValue);
	}
	
	/**
	 * �ҵ����׶���С�Ľ���
	 */
	@Test
	public void testMinTrader() {
		Optional<Transaction> optional = trasactions.stream().reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);
		System.out.println(optional);
		
	}
}
