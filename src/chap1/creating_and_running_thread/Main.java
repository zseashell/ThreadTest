package chap1.creating_and_running_thread;


public class Main {

	public static void main(String[] args) {

		for (int i = 1; i <= 10; i++) {
			Calculator calculator = new Calculator(1);
			Thread thread = new Thread(calculator);
			thread.start();
		}
	}
}
