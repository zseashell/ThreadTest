package chap1.process_thread_uncontrolled_exception;

public class Main {
	
	public static void main(String[] args) {
		Task task = new Task();
		Thread thread = new Thread(task);
		thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler());
		thread.start();
	}

}
