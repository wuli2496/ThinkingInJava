package java7Concurrent.threadsync;

import lombok.Data;

@Data
public class Account {
	private double balance;
	
	public synchronized void addAmount(double amount) {
		double tmp = balance;
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		tmp += amount;
		balance = tmp;
	}
	
	public synchronized void subAmount(double amount) {
		double tmp = balance;
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		tmp -= amount;
		balance = tmp;
	}
}
