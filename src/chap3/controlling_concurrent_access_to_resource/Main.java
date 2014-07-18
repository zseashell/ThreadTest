package chap3.controlling_concurrent_access_to_resource;

public class Main {

	public static void main(String[] args) {
		PrintQueue printQueue = new PrintQueue();
		PrintJob printJob = new PrintJob(printQueue);
		Thread[] threads = new Thread[10];
		for (int i = 0; i < 10; i++) {
			threads[i] = new Thread(printJob);
		}
		for (int i = 0; i < 10; i++) {
			threads[i].start();
		}
	}
}
