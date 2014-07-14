package controlling_interruption;

import java.util.concurrent.TimeUnit;

public class Main {
	
	public static void main(String[] args) {
		// customize your own path and fileName
		FileSearch searcher = new FileSearch("/home/cienet/work", "note.txt");
		Thread thread = new Thread(searcher);
		thread.start();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread.interrupt();
	}

}
