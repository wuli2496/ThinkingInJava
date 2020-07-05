package java7Concurrent.threadsync;

public class Bank implements Runnable {
	
	private Account account;
	
	public Bank(Account account) {
		// TODO Auto-generated constructor stub
		this.account = account;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100; ++i) {
			account.subAmount(1000);
		}
	}

}
