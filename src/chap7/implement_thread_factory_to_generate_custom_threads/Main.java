package chap7.implement_thread_factory_to_generate_custom_threads;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		MyThreadFactory myFactory = new MyThreadFactory("MyThreadFactory");
		MyTask task = new MyTask();
		Thread thread = myFactory.newThread(task);
		thread.start();
		thread.join();
		System.out.println(thread);
	}

}
