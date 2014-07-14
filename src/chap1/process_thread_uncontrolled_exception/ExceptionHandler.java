package chap1.process_thread_uncontrolled_exception;

import java.lang.Thread.UncaughtExceptionHandler;

public class ExceptionHandler  implements UncaughtExceptionHandler {

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.printf("An exception is captured\n");
		System.out.printf("Thread: %s\n", t.getId());
		System.out.printf("Exception: %s : %s\n", e.getClass().getName(), e.getMessage());
		e.printStackTrace(System.out);
		System.out.printf("Thread atatus: %s\n", t.getState());
	}

}
