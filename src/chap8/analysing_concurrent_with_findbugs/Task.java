package chap8.analysing_concurrent_with_findbugs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class Task implements Runnable {

	private Lock lock;

	public Task(Lock lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		lock.lock();
		try {
			TimeUnit.SECONDS.sleep(2);
			lock.unlock();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
