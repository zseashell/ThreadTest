package chap1.uncaught_exception_threadgroup;

public class MyThreadGroup extends ThreadGroup {

	public MyThreadGroup(String name) {
		super(name);
	}

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		System.out.printf("The thread %d has thrown an Exception\n", t.getId());
		e.printStackTrace();
		System.out.printf("Terminating the rest of the threads...\n");
		// interrupt all threads in the current thread group
		interrupt();
	}
}
