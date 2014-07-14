package chap1.using_local_thread_variable;

import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		// unsafe task
//		UnsafeTask task = new UnsafeTask();
		
		// safe task
		SafeTask task = new SafeTask();
		
		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread(task);
			thread.start();

			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
