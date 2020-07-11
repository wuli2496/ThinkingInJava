package java7Concurrent.Executor;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class FactorialCalculator implements Callable<Integer> {
	
	private Integer number;
	
	public FactorialCalculator(Integer number) {
		// TODO Auto-generated constructor stub
		this.number = number;
	}
	
	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		int result = 1;
		if (number == 0 || number == 1) {
			return 1;
		} else {
			for (int i = 2; i <= number; ++i) {
				result *= i;
			}
		}
		
		System.out.printf("%s: result:%d\n", Thread.currentThread().getName(), result);
		
		return result;
	}

}
