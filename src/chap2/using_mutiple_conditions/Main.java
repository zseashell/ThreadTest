package chap2.using_mutiple_conditions;

public class Main {

	public static void main(String[] args) {
		FileMock fileMock = new FileMock(20, 10);

		Buffer buffer = new Buffer(10);

		// single producer
		Producer producer = new Producer(fileMock, buffer);
		Thread producerThread = new Thread(producer, "producer");

		// multiple consumer
		Consumer[] consumers = new Consumer[3];
		Thread[] consumerThreads = new Thread[3];

		for (int i = 0; i < 3; i++) {
			consumers[i] = new Consumer(buffer);
			consumerThreads[i] = new Thread(consumers[i], "consumer-" + i);
		}

		// start thread
		producerThread.start();
		for (int i = 0; i < 3; i++) {
			consumerThreads[i].start();
		}
	}

}
