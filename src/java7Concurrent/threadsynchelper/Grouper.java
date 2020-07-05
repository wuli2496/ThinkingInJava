package java7Concurrent.threadsynchelper;

public class Grouper implements Runnable {

	private Results results;
	
	public Grouper(Results results) {
		// TODO Auto-generated constructor stub
		this.results = results;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int finalResult = 0;
		System.out.printf("Grouper: Processing results...\n");
		int[] data = results.getData();
		for (int number : data) {
			finalResult += number;
		}
		System.out.printf("Grouper: Total result: %d.\n", finalResult);
	}

}
