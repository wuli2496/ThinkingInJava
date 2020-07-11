package java7Concurrent.Executor;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class UserValidator {
	private String name;
	
	public UserValidator(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	
	public boolean validate(String name, String password) {
		Random random = new Random();
		
		try {
			long duration = (long)(Math.random() * 10);
			System.out.printf("Validator %s: Validating a user during %d seconds\n", this.name, duration);
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
		return random.nextBoolean();
	}
	
	public String getName() {
		return name;
	}
}
