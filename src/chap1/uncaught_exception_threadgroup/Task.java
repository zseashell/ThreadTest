package chap1.uncaught_exception_threadgroup;

import java.util.Random;

public class Task implements Runnable {

	@Override
	public void run() {
		int result;
		Random random = new Random(Thread.currentThread().getId());
		// loop until generate a zero and AritmethicException is thrown
		while (true) {
			result = 1000 / ((int) (random.nextDouble() * 1000));
			System.out.printf("%s : %d\n", Thread.currentThread().getName(),
					result);
			if (Thread.currentThread().isInterrupted()) {
				System.out.printf("%s : Interrupted\n", Thread.currentThread()
						.getName());
				return;
			}
		}
	}
}
