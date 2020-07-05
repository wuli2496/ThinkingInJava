package java7Concurrent.threadsynchelper;

import java.util.concurrent.TimeUnit;

public class Participant implements Runnable {
	
	private Videoconference conference;
	private String name;
	
	public Participant(Videoconference conference, String name) {
		// TODO Auto-generated constructor stub
		this.conference = conference;
		this.name = name;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		long duration = (long)(Math.random() * 10);
		try {
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		conference.arrive(name);
	}

}
