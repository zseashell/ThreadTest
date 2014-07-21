package chap4.running_mutiple_process_first_result;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) {

		String userName = "user";
		String password = "passwd";

		UserValidator ldapValidator = new UserValidator("LDAP");
		UserValidator dbValidator = new UserValidator("Database");

		ValidatorTask ldapTask = new ValidatorTask(ldapValidator, userName,
				password);
		ValidatorTask dbTask = new ValidatorTask(dbValidator, userName,
				password);

		List<ValidatorTask> taskList = new ArrayList<>();
		taskList.add(ldapTask);
		taskList.add(dbTask);

		ExecutorService executor = Executors.newCachedThreadPool();
		String result;
		try {
			result = executor.invokeAny(taskList);
			System.out.printf("Main: result is %s\n", result);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		executor.shutdown();
		System.out.printf("Main: end of the execution\n");
	}

}
