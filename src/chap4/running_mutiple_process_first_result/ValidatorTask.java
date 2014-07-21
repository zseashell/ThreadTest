package chap4.running_mutiple_process_first_result;

import java.util.concurrent.Callable;

public class ValidatorTask implements Callable<String> {

	private UserValidator validator;

	private String userName;

	private String password;

	public ValidatorTask(UserValidator validator, String userName,
			String password) {
		this.validator = validator;
		this.userName = userName;
		this.password = password;
	}

	@Override
	public String call() throws Exception {
		if (!validator.validta(userName, password)) {
			System.out.printf("%s: user matching failed!\n", validator.getName());
			throw new Exception("Error validating user");
		}
		System.out.printf("%s: user matching successed!\n", validator.getName());
		return validator.getName();
	}

}
