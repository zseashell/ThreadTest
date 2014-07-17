package chap2.using_condition_in_synchronized_code;

public class Main {

	public static void main(String[] args) {
		
		EventStorage eventStorage = new EventStorage();
		
		// run producer and consumer
		Producer producer = new Producer(eventStorage);
		Thread thread1 = new Thread(producer);
		
		Consumer consumer = new Consumer(eventStorage);
		Thread thread2 = new Thread(consumer);
		
		thread1.start();
		thread2.start();

	}

}
