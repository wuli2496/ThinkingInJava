package java7Concurrent.threadsync;

import java.util.Random;

public class BufferConsumer implements Runnable {
	private Buffer buffer;
	
	public BufferConsumer(Buffer buffer) {
		// TODO Auto-generated constructor stub
		this.buffer = buffer;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (buffer.hasPendingLines()) {
			String line = buffer.get();
			processLine(line);
		}

	}

	private void processLine(String line) {
		try {
			Random random = new Random();
			Thread.sleep(random.nextInt(100));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
