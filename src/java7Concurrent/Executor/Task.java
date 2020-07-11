package java7Concurrent.Executor;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Task implements Runnable {
	private Date initDate;
	
	private String name;
	
	public Task(String name) {
		// TODO Auto-generated constructor stub
		initDate = new Date();
		this.name = name;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.printf("%s: Task %s: Created on: %s\n", Thread.currentThread().getName(),
				name, initDate);
		
		System.out.printf("%s: Task %s: Stated on: %s\n", Thread.currentThread().getName(),
				name, new Date());
		
		try {
			Long duration = (long)(Math.random() * 10);
			System.out.printf("%s: Task %s: Doing a task during %d seconds\n", Thread.currentThread().getName(), 
					name, duration);
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.printf("%s: Task %s: Finished on: %s\n", Thread.currentThread().getName(),
				name, new Date());
	}

}
