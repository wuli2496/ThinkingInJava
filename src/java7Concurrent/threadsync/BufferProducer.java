package java7Concurrent.threadsync;

public class BufferProducer implements Runnable {
	private FileMock mock;
	private Buffer buffer;
	
	public BufferProducer(FileMock mock, Buffer buffer) {
		// TODO Auto-generated constructor stub
		this.mock = mock;
		this.buffer = buffer;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		buffer.setPendingLines(true);
		while (mock.hasMoreLines()) {
			String line = mock.getLine();
			buffer.insert(line);
		}
		
		buffer.setPendingLines(false);
	}

}
