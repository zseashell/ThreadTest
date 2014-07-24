package chap7.use_thread_factory_in_executor;

import java.util.concurrent.TimeUnit;

public class MyTask implements Runnable {

	@Override
	public void run() {

		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
