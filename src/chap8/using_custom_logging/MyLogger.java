package chap8.using_custom_logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyLogger {

	private static Handler handler;

	public static Logger getLogger(String name) {
		Logger logger = Logger.getLogger(name);
		logger.setLevel(Level.ALL);

		try {
			if (handler == null) {
				handler = new FileHandler("test.log");
				Formatter formatter = new MyFormatter();
				handler.setFormatter(formatter);
			}
			if (logger.getHandlers().length == 0) {
				logger.addHandler(handler);
			}
		} catch (SecurityException | IOException e) {
			e.printStackTrace();
		}
		return logger;

	}

}
