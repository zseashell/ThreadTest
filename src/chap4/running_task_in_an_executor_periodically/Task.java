package chap4.running_task_in_an_executor_periodically;

import java.util.Date;

public class Task implements Runnable {

	private String name;

	public Task(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.printf("%s starting at %s\n", name, new Date());
	}
}
