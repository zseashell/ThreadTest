package chap4.control_a_task_finishing_in_executor;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class ExecutableTask implements Callable<String> {

	private String name;

	public ExecutableTask(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String call() throws Exception {
		// just sleep for some random period of time
		long duration = (long) (Math.random() * 10);
		System.out.printf("%s waiting %d seconds for results.\n", name,
				duration);
		TimeUnit.SECONDS.sleep(duration);
		return name;
	}

}
