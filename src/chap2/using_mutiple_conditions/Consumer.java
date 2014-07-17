package chap2.using_mutiple_conditions;

public class Consumer implements Runnable {

	private Buffer buffer;

	public Consumer(Buffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		while (buffer.hasPendingLines()) {
			String line = buffer.get();
			processLine(line);
		}
	}

	private void processLine(String line) {
		System.out.println(Thread.currentThread().getName()
				+ " start process line...");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()
				+ " finish process line...");
	}

}
