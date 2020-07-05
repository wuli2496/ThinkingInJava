package java7Concurrent.threadsync;

public class Consumer implements Runnable {

	private EventStorage storage;
	
	public Consumer(EventStorage storage) {
		// TODO Auto-generated constructor stub
		this.storage = storage;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100; ++i) {
			storage.get();
		}
	}

}
