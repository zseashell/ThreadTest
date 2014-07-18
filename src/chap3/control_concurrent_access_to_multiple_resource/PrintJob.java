package chap3.control_concurrent_access_to_multiple_resource;

public class PrintJob implements Runnable {

	private PrintQueue printQueue;

	public PrintJob(PrintQueue printQueue) {
		this.printQueue = printQueue;
	}

	@Override
	public void run() {
		System.out.printf("%s start print a document...\n", Thread
				.currentThread().getName());
		printQueue.printDocument(new Object());
		System.out.printf("%s finish print a document...\n", Thread
				.currentThread().getName());
	}

}
