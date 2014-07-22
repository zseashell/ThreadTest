package chap4.seperate_launch_and_result_processing_in_executor;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class ReportGenerator implements Callable<String> {

	private String sender;

	private String title;

	public ReportGenerator(String sender, String title) {
		this.sender = sender;
		this.title = title;
	}

	@Override
	public String call() throws Exception {
		long duration = (long) (Math.random() * 10);
		System.out.printf("%s_%s generating report during %d seconds\n",
				sender, title, duration);
		TimeUnit.SECONDS.sleep(duration);
		return sender + ":" + title;
	}

}
