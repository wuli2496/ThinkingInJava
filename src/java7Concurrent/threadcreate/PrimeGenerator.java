package java7Concurrent.threadcreate;

public class PrimeGenerator extends Thread {
	
	@Override
	public void run() {
		long number = 1L;
		
		while (true) {
			if (isPrime(number)) {
				System.out.printf("Number %d is Prime\n", number);
			}
			
			if (isInterrupted()) {
				System.out.println("The Prime Generator has been Interrupted");
				break;
			}
			
			++number;
		}
	}
	
	private boolean isPrime(long num) {
		if (num <= 2) {
			return true;
		}
		
		for (long i = 2; i * i <= num; ++i) {
			if (num % i == 0) {
				return false;
			}
		}
		
		return true;
	}
}
