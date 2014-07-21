package chap4.running_mutiple_process_all_result;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Task implements Callable<Result> {

	private String name;

	public Task(String name) {
		this.name = name;
	}

	@Override
	public Result call() throws Exception {
		System.out.printf("%s: starting...\n", name);
		try {
			long duration = (long) (Math.random() * 10);
			System.out.printf("%s: waiting %d seconds for results\n", name,
					duration);
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// generate result
		int value = 0;
		for (int i = 0; i < 5; i++) {
			value += (int) (Math.random() * 100);
		}

		// construct result
		Result result = new Result();
		result.setName(name);
		result.setValue(value);

		System.out.printf("%s: finish...\n", name);

		return result;
	}

}
