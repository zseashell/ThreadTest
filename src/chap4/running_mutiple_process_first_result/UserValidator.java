package chap4.running_mutiple_process_first_result;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class UserValidator {

	private String name;

	public UserValidator(String name) {
		this.name = name;
	}

	// simulate the behavior of user validation
	public boolean validta(String userName, String password) {
		Random random = new Random();

		try {
			long duration = (long) (Math.random() * 10);
			System.out.printf("Validator %s validate user during %d seconds\n",
					name, duration);
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			return false;
		}

		return random.nextBoolean();
	}

	public String getName() {
		return name;
	}

}
