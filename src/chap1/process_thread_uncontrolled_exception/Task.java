package chap1.process_thread_uncontrolled_exception;

public class Task implements Runnable {

	/**
	 * 1. Checked Exception need to be caught, because run() doesn't support throws clause
	 * 2. UnChecked Exception's default behavior is to write stack trace and exit
	 */
	@Override
	public void run() {
		int numbero = Integer.parseInt("TTT");
	}

}
