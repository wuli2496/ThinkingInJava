package java7Concurrent.test;

import java.nio.Buffer;

import org.junit.Test;

import java7Concurrent.threadsync.Account;
import java7Concurrent.threadsync.Bank;
import java7Concurrent.threadsync.BufferConsumer;
import java7Concurrent.threadsync.BufferProducer;
import java7Concurrent.threadsync.Cinema;
import java7Concurrent.threadsync.Company;
import java7Concurrent.threadsync.Consumer;
import java7Concurrent.threadsync.EventStorage;
import java7Concurrent.threadsync.FileMock;
import java7Concurrent.threadsync.Job;
import java7Concurrent.threadsync.PricesInfo;
import java7Concurrent.threadsync.PrintQueue;
import java7Concurrent.threadsync.Producer;
import java7Concurrent.threadsync.Reader;
import java7Concurrent.threadsync.TicketOffice1;
import java7Concurrent.threadsync.TicketOffice2;
import java7Concurrent.threadsync.Writer;

public class concurrentThreadSyncTest {
	
	@Test
	public void testAccount() {
		Account account = new Account();
		account.setBalance(1000);
		
		Runnable comRunnable = new Company(account);
		Runnable baRunnable = new Bank(account);
		
		Thread comThread = new Thread(comRunnable);
		Thread baThread = new Thread(baRunnable);
		
		System.out.printf("Account: Initial balance:%f\n", account.getBalance());
		
		comThread.start();
		baThread.start();
		
		try {
			comThread.join();
			baThread.join();
			System.out.printf("Account: Final balance:%f\n", account.getBalance());
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCinema() {
		Cinema cinema = new Cinema();
		Runnable ticketOffice1 = new TicketOffice1(cinema);
		Thread office1Thread = new Thread(ticketOffice1, "TicketOffice1");
		Runnable ticketOffice2 = new TicketOffice2(cinema);
		Thread office2Thread = new Thread(ticketOffice2, "TicketOffice2");
		
		office1Thread.start();
		office2Thread.start();
		
		try {
			office1Thread.join();
			office2Thread.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		System.out.printf("Room 1 Vacancies: %d\n", cinema.getVacanciesCinema1());
		System.out.printf("Room 2 Vacancies: %d\n", cinema.getVacanciesCinema2());
	}
	
	@Test
	public void testSyncCondition() {
		EventStorage eventStorage = new EventStorage();
		Runnable proRunnable = new Producer(eventStorage);
		Thread proThread = new Thread(proRunnable);
		
		Runnable conRunnable = new Consumer(eventStorage);
		Thread conThread = new Thread(conRunnable);
		
		proThread.start();
		conThread.start();
		
		try {
			proThread.join();
			conThread.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void testLock() {
		PrintQueue printQueue = new PrintQueue();
		Runnable jobRunnable = new Job(printQueue);
		final int N = 10;
		Thread[] jobThreads = new Thread[N];
		for (int i = 0; i < N; ++i) {
			jobThreads[i] = new Thread(jobRunnable, "Thread_" + i);
			jobThreads[i].start();
		}
		
		try {
			for (int i = 0; i < N; ++i) {
				jobThreads[i].join();
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void testReadWriterLock() {
		PricesInfo pricesInfo = new PricesInfo();
		final int READER_N = 5;
		Runnable[] readers = new Reader[READER_N];
		Thread[] readerThreads = new Thread[READER_N];
		
		for (int i = 0; i < READER_N; ++i) {
			readers[i] = new Reader(pricesInfo); 
			readerThreads[i] = new Thread(readers[i]); 
		}
		
		Runnable writerRunnable = new Writer(pricesInfo);
		Thread writerThread = new Thread(writerRunnable);
		
		for (int i = 0; i < READER_N; ++i) {
			readerThreads[i].start();
		}
		
		writerThread.start();
		
		try {
			for (int i = 0; i < READER_N; ++i) {
				readerThreads[i].join();
			}
			
			writerThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCondition() {
		FileMock mock = new FileMock(100,  10);
		java7Concurrent.threadsync.Buffer buffer = new java7Concurrent.threadsync.Buffer(20);
		
		Runnable producerRunnable = new BufferProducer(mock, buffer);
		Thread producerThread = new Thread(producerRunnable);
		
		final int CONSUMER_N = 3;
		Runnable[] consumesRunnable = new BufferConsumer[CONSUMER_N];
		Thread[] consumersThread = new Thread[CONSUMER_N];
		for (int i = 0; i < CONSUMER_N; ++i) {
			consumesRunnable[i] = new BufferConsumer(buffer);
			consumersThread[i] = new Thread(consumesRunnable[i]);
			consumersThread[i].start();
		}
		
		producerThread.start();
		
		try {
			for (int i = 0; i < CONSUMER_N; ++i) {
				consumersThread[i].join();
			}
			
			producerThread.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		 
	}
}
