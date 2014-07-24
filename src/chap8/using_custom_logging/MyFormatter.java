package chap8.using_custom_logging;

import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class MyFormatter extends Formatter {

	@Override
	public String format(LogRecord record) {
		StringBuilder sb = new StringBuilder();
		sb.append("[" + record.getLevel() + "] - ");
		sb.append(new Date(record.getMillis()) + " : ");
		sb.append(record.getSourceClassName() + "."
				+ record.getSourceClassName() + " : ");
		sb.append(record.getMessage() + "\n");
		return sb.toString();
	}

}
