package java7Concurrent.threadcreate;

import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

public class WriterTask implements Runnable {

	private Deque<Event> deque;
	
	public WriterTask(Deque<Event> deque) {
		this.deque = deque;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100; ++i) {
			Event event = new Event();
			event.setDate(new Date());
			event.setEvent(String.format("The thread %s has generated ans event", Thread.currentThread().getId()));
			deque.addFirst(event);
			
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

}
