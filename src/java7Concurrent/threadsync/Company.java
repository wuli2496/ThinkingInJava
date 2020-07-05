package java7Concurrent.threadsync;

public class Company implements Runnable {
	
	private Account account;
	
	public Company(Account account) {
		// TODO Auto-generated constructor stub
		this.account = account;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100; ++i) {
			account.addAmount(1000);
		}
	}

}
