package java7Concurrent.threadsync;

public class Writer implements Runnable {

	private PricesInfo pricesInfo;
	
	public Writer(PricesInfo pricesInfo) {
		// TODO Auto-generated constructor stub
		this.pricesInfo = pricesInfo;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 3; ++i) {
			System.out.println("Writer: Attempt to modify the prices.");
			pricesInfo.setPrices(Math.random() * 10, Math.random() * 8);
			System.out.println("Writer: Prices have been modifyed.");
			
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

}
