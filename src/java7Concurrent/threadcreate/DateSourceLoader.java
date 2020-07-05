package java7Concurrent.threadcreate;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateSourceLoader implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.printf("Beginning date sources loading: %s\n", new Date());
		
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		System.out.printf("Date sources loading has finished: %s\n", new Date());
	}

}
