package java7Concurrent.threadsynchelper;

import java.sql.Time;
import java.util.Arrays;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {
	private final Semaphore semaphore;
	private boolean[] freePrinters;
	private Lock lockPrinters;
	private final int N = 3;
	
	public PrintQueue() {
		// TODO Auto-generated constructor stub
		semaphore = new Semaphore(N);
		freePrinters = new boolean[N];
		Arrays.fill(freePrinters, true);
		
		lockPrinters = new ReentrantLock();
	}
	
	public void printJob(Object object) {
		try {
			semaphore.acquire();
			int assignedPinter = getPrinter();
			long duration = (long)(Math.random() * 10);
			System.out.printf("%s: PrintQueue: Printing a Job in Printer %d during %d seconds\n", 
					Thread.currentThread().getName(), assignedPinter, duration);
			TimeUnit.SECONDS.sleep(duration);
			freePrinters[assignedPinter] = true;
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			semaphore.release();
		}
	}
	
	private int getPrinter() {
		int ret = -1;
		
		try {
			lockPrinters.lock();
			for (int i = 0; i < freePrinters.length; ++i) {
				if (freePrinters[i]) {
					freePrinters[i] = false;
					ret = i;
					break;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			lockPrinters.unlock();
		}
		
		return ret;
	}
}
