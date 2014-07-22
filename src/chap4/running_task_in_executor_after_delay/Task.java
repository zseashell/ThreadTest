package chap4.running_task_in_executor_after_delay;

import java.util.Date;
import java.util.concurrent.Callable;

public class Task implements Callable<String> {
	
	private String name;
	
	public Task(String name) {
		this.name = name;
	}

	@Override
	public String call() throws Exception {
		System.out.printf("%s starting at %s\n", name, new Date());
		return "";
	}

}
