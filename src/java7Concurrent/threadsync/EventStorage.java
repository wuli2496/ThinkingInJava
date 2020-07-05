package java7Concurrent.threadsync;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class EventStorage {
	private int maxSize;
	private List<Date> storage;
	
	public EventStorage() {
		// TODO Auto-generated constructor stub
		maxSize = 10;
		storage = new LinkedList<Date>();
	}
	
	public synchronized void set() {
		while (storage.size() == maxSize) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		storage.add(new Date());
		System.out.printf("Set: %d\n",  storage.size());
		notifyAll();
	}
	
	public synchronized void get() {
		while (storage.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		System.out.printf("Get: %d: %s\n", storage.size(), ((LinkedList<?>)storage).poll());
		notifyAll();
	}
}
