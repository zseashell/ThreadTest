package chap8.using_custom_logging;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

	public static void main(String[] args) {
		Logger logger = MyLogger.getLogger("Core");
		logger.entering("Core", "main()", args);
		Thread[] threads = new Thread[5];
		for (int i=0; i<threads.length; i++) {
			logger.log(Level.INFO, "Launching thread-" +i);
			Task task = new Task();
			threads[i] = new Thread(task);
			logger.log(Level.INFO, "Start thread-" +i);
			threads[i].start();
		}
		
		logger.log(Level.INFO, "Waiting threads to finish...");
		for (int i=0; i<threads.length; i++) {
			try {
				threads[i].join();
				logger.log(Level.INFO, "thread-" + i + " has finished!", threads[i]);
			} catch (InterruptedException e) {
				logger.log(Level.SEVERE, "Exception", e);
			}
		}
		
		logger.exiting("Core", "main()");
	}

}
