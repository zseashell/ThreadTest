package chap2.modify_lock_fairness;

public class Main {

	public static void main(String[] args) {

		PrintQueue printQueue = new PrintQueue();

		// create print job task
		Thread[] threads = new Thread[10];
		for (int i = 0; i < 10; i++) {
			Document document = new Document("Doc_" + i);
			PrintJob printJob = new PrintJob(document, printQueue);
			threads[i] = new Thread(printJob);
		}

		// start all print job
		for (int i = 0; i < 10; i++) {
			threads[i].start();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
