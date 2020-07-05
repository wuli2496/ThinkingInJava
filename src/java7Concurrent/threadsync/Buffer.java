package java7Concurrent.threadsync;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


public class Buffer {
	private List<String> buffer;
	private int maxSize;
	private ReentrantLock lock;
	private Condition linesCondition;
	private Condition spaceCondition;
	private boolean pendingLines;
	
	public Buffer(int maxSize) {
		// TODO Auto-generated constructor stub
		this.maxSize = maxSize;
		buffer = new LinkedList<>();
		lock = new ReentrantLock();
		linesCondition = lock.newCondition();
		spaceCondition = lock.newCondition();
		pendingLines = true;
	}
	
	public void insert(String line) {
		lock.lock();
		
		try {
			while (buffer.size() == maxSize) {
				spaceCondition.await();
			}
			
			buffer.add(line);
			System.out.printf("%s: Inserted Line: %d\n", Thread.currentThread().getName(),
					buffer.size());
			linesCondition.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public String get() {
		lock.lock();
	
		String line = null;
		try {
			while (buffer.size() == 0 && hasPendingLines()) {
				linesCondition.await();
			}
			
			if (hasPendingLines()) {
				line = ((LinkedList<String>)buffer).poll();
				System.out.printf("%s: Line Readed: %d\n", Thread.currentThread().getName(),
						buffer.size());
				spaceCondition.signalAll();
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		
		return line;
	}
	
	public boolean hasPendingLines() {
		return pendingLines || buffer.size() > 0;
	}
	
	public void setPendingLines(boolean pendingLines) {
		this.pendingLines = pendingLines;
	}
}
