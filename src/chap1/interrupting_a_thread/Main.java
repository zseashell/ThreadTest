package chap1.interrupting_a_thread;

public class Main {

	public static void main(String[] args) {
		Thread generator = new PrimeGenerator();
		generator.start();
		
		// main thread sleep for some period of time
		try{
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		generator.interrupt();
	}
}
