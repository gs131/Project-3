import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDateTime;

/**
 * Logger that writes messages to the console (System.err)
 * The Logger outputs the messages in a format determined
 * by its associated Formatter
 */
public class ConsoleLogger extends SimpleLogger {
	private static ConsoleLogger inst = null;

	private ConsoleLogger() {
		System.err.println("in ConsoleLogger constructor");
	}

	/**
	 * logs a message to the console, using the format set 
	 * by the attached formatter
	 */
	@Override
	public void log(Level logLevel, String component, String msg) throws LoggerException {
		if (currLevel.permitsLogging(logLevel)) {
			LocalDateTime now = LocalDateTime.now();
			LogMessage logMsg = new LogMessage(logLevel, now, component, msg);
			String logStr = formatter.format(logMsg);
			System.err.println(logStr);
		}
	}

	public static ConsoleLogger getInstance() {
		if (inst == null)
			inst = new ConsoleLogger();

		return inst;
	}

	/**
	 * logs an exception to the console, using the format set
	 * by the attached formatter. The exception stack trace
	 * is logged
	 */
	@Override
	public void log(Level logLevel, String component, Throwable t) throws LoggerException {
		if (currLevel.permitsLogging(logLevel))		{
			StringWriter sw = new StringWriter();
			t.printStackTrace(new PrintWriter(sw));
			String exceptionDetails = sw.toString();

			LocalDateTime now = LocalDateTime.now();
			LogMessage logMsg = new LogMessage(logLevel, now, component, exceptionDetails);
			String logStr = formatter.format(logMsg);

			System.err.println(logStr);
		}
	}

}
