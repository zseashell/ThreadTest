package chap2.modify_lock_fairness;

public class PrintJob implements Runnable {
	
	private Document document;

	private PrintQueue printQueue;

	public PrintJob(Document document, PrintQueue printQueue) {
		this.document = document;
		this.printQueue = printQueue;
	}

	@Override
	public void run() {
		System.out.printf("%s: start print a document...\n", Thread.currentThread().getName());
		printQueue.printDoc(document);
		System.out.printf("%s: finish print a document...\n", Thread.currentThread().getName());
	}

}
