package java7Concurrent.test;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Phaser;

import org.junit.Test;

import java7Concurrent.threadsynchelper.FileSearch;
import java7Concurrent.threadsynchelper.Grouper;
import java7Concurrent.threadsynchelper.Job;
import java7Concurrent.threadsynchelper.MatrixMock;
import java7Concurrent.threadsynchelper.Participant;
import java7Concurrent.threadsynchelper.PrintQueue;
import java7Concurrent.threadsynchelper.Results;
import java7Concurrent.threadsynchelper.Searcher;
import java7Concurrent.threadsynchelper.Videoconference;

public class concurrentThreadSyncHelperTest {
	@Test
	public void testSemaphore() {
		PrintQueue printQueue = new PrintQueue();
		final int N = 10;
		Thread[] threads = new Thread[N];
		for (int i = 0; i < N; ++i) {
			threads[i] = new Thread(new Job(printQueue), "Thread" + i); 
			threads[i].start();
		}
		
		try {
			for (int i = 0; i < N; ++i) {
				threads[i].join();
			} 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCountDownLatch() {
		final int N = 10;
		Videoconference videoconference = new Videoconference(N);
		Thread threadConference = new Thread(videoconference);
		threadConference.start();
		
		Runnable[] paticipant = new Participant[N];
		Thread[] parThreads = new Thread[N];
		
		for (int i = 0; i < N; ++i) {
			paticipant[i] = new Participant(videoconference, "Participant_" + i);
			parThreads[i] = new Thread(paticipant[i]); 
			parThreads[i].start();
		}
		
		try {
			for (int i = 0; i < N; ++i) {
				parThreads[i].join();
			}
			
			threadConference.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCyclicBarrier() {
		final int ROWS = 10000;
		final int NUMBERS = 1000;
		final int SEARCH = 5;
		final int PARTICIPANTS = 5;
		final int LINES_PARTICIPANT = 2000;
		
		MatrixMock mock = new MatrixMock(ROWS, NUMBERS, SEARCH);
		Results results = new Results(ROWS);
		
		Runnable groupTask = new Grouper(results);
		CyclicBarrier barrier = new CyclicBarrier(PARTICIPANTS, groupTask);
		
		Runnable[] searchTask = new Searcher[PARTICIPANTS];
		Thread[] searchThreads = new Thread[PARTICIPANTS];
		for (int i = 0; i < PARTICIPANTS; ++i) {
			searchTask[i] = new Searcher(i * LINES_PARTICIPANT, (i * LINES_PARTICIPANT) + LINES_PARTICIPANT, mock, results, SEARCH, barrier);
			searchThreads[i] = new Thread(searchTask[i]);
			searchThreads[i].start();
		}
		
		System.out.printf("Main: The main thread has finished.\n");
		 
		try {
			for (int i = 0; i < PARTICIPANTS; ++i) {
				searchThreads[i].join();
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
 	}
	
	@Test
	public void testPhaser() {
		Phaser phaser = new Phaser(3);
		Runnable systemFileSearch = new FileSearch("C:\\Windows", "log", phaser);
		Runnable appFileSearch = new FileSearch("C:\\Program Files", "log", phaser);
		Runnable documentsSearch = new FileSearch("C:\\Documents And Settings", "log", phaser);
		
		Thread systeThread = new Thread(systemFileSearch, "System");
		Thread appThread = new Thread(appFileSearch, "Apps");
		Thread documentThread = new Thread(documentsSearch, "Documents");
		systeThread.start();
		appThread.start();
		documentThread.start();
		
		try {
			systeThread.join();
			appThread.join();
			documentThread.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		System.out.println("Terminated: " + phaser.isTerminated());
	}
}
