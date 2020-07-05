package java7Concurrent.test;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.Thread.State;
import java.util.ArrayDeque;
import java.util.Date;
import java.util.Deque;
import java.util.Random;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import org.junit.Test;

import java7Concurrent.threadcreate.Calculator;
import java7Concurrent.threadcreate.CleanerTask;
import java7Concurrent.threadcreate.DateSourceLoader;
import java7Concurrent.threadcreate.Event;
import java7Concurrent.threadcreate.ExceptionHandler;
import java7Concurrent.threadcreate.FileClock;
import java7Concurrent.threadcreate.FileSearch;
import java7Concurrent.threadcreate.MyThreadFactory;
import java7Concurrent.threadcreate.PrimeGenerator;
import java7Concurrent.threadcreate.SafeTask;
import java7Concurrent.threadcreate.Task;
import java7Concurrent.threadcreate.UnsafeTask;
import java7Concurrent.threadcreate.WriterTask;

public class concurrentThreadCreateTest {

	@Test
	public void testDaemon() throws Exception {
		Deque<Event> deque = new ArrayDeque<>();
		WriterTask writerTask = new WriterTask(deque);
		Thread[] threads = new Thread[4];
		
		for (int i = 0; i < 3; ++i) {
			threads[i] = new Thread(writerTask); 
			threads[i].start();
		}
		
		CleanerTask cleanerTask = new CleanerTask(deque);
		threads[3] = cleanerTask;
		cleanerTask.start();
		
		for (int i = 0; i < 4; ++i) {
			threads[i].join();
		}
	}
	
	@Test
	public void testCaughtExceptionHandler() throws Exception {
		Runnable task = new Task();
		Thread thread = new Thread(task);
		thread.setUncaughtExceptionHandler(new ExceptionHandler());
		thread.start();
		
		thread.join();
	}
	
	private static void writeThreadInfo(PrintWriter pw, Thread thread, State state) {
		pw.printf("Main: Id %d - %s\n", thread.getId(), thread.getName());
		pw.printf("Main : Priority: %d\n", thread.getPriority());
		pw.printf("Main : Old State: %s\n", state);
		pw.printf("Main : New State: %s\n", thread.getState());
		pw.printf("Main : ************\n");
	}
	
	@Test
	public void testCalculator() throws Exception {
		final int N = 10;
		
		Thread[] threads = new Thread[N];
		Thread.State[] statuStates = new Thread.State[N];
		
		for (int i = 0; i < N; ++i) {
			threads[i] = new Thread(new Calculator(i));
			if (i % 2 == 0) {
				threads[i].setPriority(Thread.MAX_PRIORITY);
			} else {
				threads[i].setPriority(Thread.MIN_PRIORITY);
			}
			
			threads[i].setName("Thread" + i);
		}
		
		try (FileWriter fileWriter = new FileWriter("F:\\OJ\\uva_in.txt");
				PrintWriter pWriter = new PrintWriter(fileWriter);) {
			
			for (int i = 0; i < N; ++i) {
				pWriter.println("Main: Status of Thread " + i + ":" + threads[i].getState());
				statuStates[i] = threads[i].getState(); 
			}
			
			for (int i = 0; i < N; ++i) {
				threads[i].start();
			}
			
			boolean finished = false;
			while (!finished) {
				for (int i = 0; i < N; ++i) {
					if (threads[i].getState() != statuStates[i]) {
						writeThreadInfo(pWriter, threads[i], statuStates[i]);
						statuStates[i] = threads[i].getState(); 
					}
				}
				
				finished = true;
				for (int i = 0; i < N; ++i) {
					finished = finished && (threads[i].getState() == State.TERMINATED);
				}
			}
		}
		
		for (int i = 0; i < N; ++i) {
			threads[i].join();
		}
	}
	
	@Test
	public void testDataSourceLoader() throws Exception {
		Runnable task = new DateSourceLoader();
		Thread t1 = new Thread(task);
		Thread t2 = new Thread(task);
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		System.out.printf("Main : configuration has been loaded: %s\n", new Date());
		
		t1.join();
		t2.join();
	}
	
	@Test
	public void testFileClock() throws Exception {
		Runnable task = new FileClock();
		Thread thread = new Thread(task);
		thread.start();
		
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		thread.interrupt();
		thread.join();
	}
	
	@Test
	public void testFileSearch() throws Exception {
		Runnable task = new FileSearch("c:\\", "autoexec.bat");
		Thread thread = new Thread(task);
		thread.start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		thread.interrupt();
		thread.join();
	}
	
	@Test
	public void testPrimeGenerator() throws Exception {
		Thread taskThread = new PrimeGenerator();
		taskThread.start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		taskThread.interrupt();
		taskThread.join();
	}
	
	@Test
	public void testUnsafeTask() throws Exception {
		Runnable task = new UnsafeTask();
		final int N = 10;
		Thread[] threads = new Thread[N];
		for (int i = 0; i < N; ++i) {
			threads[i] = new Thread(task);
			threads[i].start();
			
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		for (int i = 0; i < N; ++i) {
			threads[i].join();
		}
	}
	
	@Test
	public void testSafeTask() throws Exception {
		Runnable task = new SafeTask();
		final int N = 10;
		Thread[] threads = new Thread[N];
		for (int i = 0; i < N; ++i) {
			threads[i] = new Thread(task);
			threads[i].start();
			
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
		for (int i = 0; i < N; ++i) {
			threads[i].join();
		}
	}
	
	@Test
	public void testThreadFactory() throws Exception {
		MyThreadFactory threadFactory = new MyThreadFactory("MyThreadFactory");
		Runnable runnable = new Task();
		final int N = 10;
		Thread[] threads = new Thread[N];
		
		for (int i = 0; i < N; ++i) {
			threads[i] = threadFactory.newThread(runnable);
			threads[i].start();
		}
		
		System.out.println("Factory Stats:");
		System.out.printf("%s\n", threadFactory.getStats());
		
		for (int i = 0; i < N; ++i) {
			threads[i].join();
		}
	}
}
