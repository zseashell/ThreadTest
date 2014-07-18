package chap3.synchronize_task_at_common_point;

public class Grouper implements Runnable {

	private Result result;

	public Grouper(Result result) {
		this.result = result;
	}

	@Override
	public void run() {
		int finalResult = 0;
		System.out.println("Grouper processing result...");

		int[] data = result.getData();
		for (int number : data) {
			finalResult += number;
		}
		System.out.printf("Grouper: Total result is %d.\n", finalResult);
	}

}
