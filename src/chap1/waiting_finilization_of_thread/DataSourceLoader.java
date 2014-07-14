package chap1.waiting_finilization_of_thread;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DataSourceLoader implements Runnable {

	@Override
	public void run() {
		System.out.printf("Begin loading data source %s\n", new Date());
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Finish loading data source %s\n", new Date());
	}

}
