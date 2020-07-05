package java7Concurrent.threadcreate;

import java.util.concurrent.TimeUnit;

public class Task implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
