package chap7.implement_thread_factory_to_generate_custom_threads;

import java.util.concurrent.ThreadFactory;

public class MyThreadFactory implements ThreadFactory {

	private int counter;

	private String prefix;

	public MyThreadFactory(String prefix) {
		this.prefix = prefix;
		counter = 1;
	}

	@Override
	public Thread newThread(Runnable r) {
		MyThread myThread = new MyThread(r, prefix + "-" + counter);
		counter++;
		return myThread;
	}

}
