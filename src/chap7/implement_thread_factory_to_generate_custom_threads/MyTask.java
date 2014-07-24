package chap7.implement_thread_factory_to_generate_custom_threads;

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
