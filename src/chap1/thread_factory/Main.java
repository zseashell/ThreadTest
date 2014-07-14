package chap1.thread_factory;

public class Main {

	public static void main(String[] args) {
		MyThreadFactory factory = new MyThreadFactory("MyThreadFactory");
		Task task = new Task();

		Thread thread;
		System.out.println("Starting create thread by thread factory...");
		for (int i = 0; i < 10; i++) {
			thread = factory.newThread(task);
			thread.start();
		}

		System.out.println("The stats of factory:");
		System.out.printf("%s\n", factory.getStats());
	}

}
