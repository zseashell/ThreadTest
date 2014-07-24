package chap8.monitor_lock_interface;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class Task implements Runnable {

	private Lock lock;

	public Task(Lock lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			lock.lock();
			System.out.printf("%s get the lock.\n'", Thread.currentThread()
					.getName());
			try {
				TimeUnit.SECONDS.sleep(1);
				System.out.printf("%s free the lock.\n", Thread.currentThread()
						.getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
	}

}
