package chap4.cancel_task_in_a_executor;

import java.util.concurrent.Callable;

public class Task implements Callable<String> {

	@Override
	public String call() throws Exception {
		while (true) {
			System.out.println("Task: running...");
			Thread.sleep(100);
		}
	}

}
