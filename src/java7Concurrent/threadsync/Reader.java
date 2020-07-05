package java7Concurrent.threadsync;

public class Reader implements Runnable {
	private PricesInfo pricesInfo;
	
	public Reader(PricesInfo pricesInfo) {
		// TODO Auto-generated constructor stub
		this.pricesInfo = pricesInfo;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; ++i) {
			System.out.printf("%s: Price 1: %f, Price 2: %f\n",  
					Thread.currentThread().getName(), pricesInfo.getPrice1(),
					pricesInfo.getPrice2());
		
		}
	}

}
