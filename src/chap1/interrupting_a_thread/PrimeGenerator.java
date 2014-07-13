package chap1.interrupting_a_thread;

public class PrimeGenerator extends Thread {
	
	@Override
	public void run() {
		long number = 1L;
		while (true) {
			if (isPrime(number)) {
				System.out.printf("Number: %d is a prime.\n", number);
			}
			// check out if the thread is interrupted
			if (isInterrupted()) {
				System.out.println("The prime generator thread is interrupted!");
				return;
			}
			number++;
		}
	}
	
	private static boolean isPrime(long number) {
		if (number <= 2) {
			return true;
		}
		for (long i=2; i<number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

}
