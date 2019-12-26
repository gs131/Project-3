
/**
 * Logger that writes messages to a default file: File.txt
 * The Logger outputs the messages in a format determined
 * by its associated Formatter
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class FileLogger extends SimpleLogger {
	private static FileLogger inst = null;
	private FileWriter outFile;

	private FileLogger() {
      // private so it can't be called from anywhere except
	  // getInstance
	}

	/**
	 * logs a message to the log file, using the format set 
	 * by the attached formatter
	 */
	@Override
	public void log(Level logLevel, String component, String msg) throws LoggerException {
		if (currLevel.permitsLogging(logLevel)) {
			LocalDateTime now = LocalDateTime.now();
			LogMessage logMsg = new LogMessage(logLevel, now, component, msg);
			String logStr = formatter.format(logMsg);
			try {
				outFile = new FileWriter(new File("log.txt"), true);
				outFile.write(logStr);

				outFile.close();
			} catch (IOException e) {
				throw new LoggerException("could not log to file", e);
			}
		}

	}

	public static FileLogger getInstance() {
		if (inst == null)
			inst = new FileLogger();

		return inst;
	}

	/**
	 * logs an exception to the log file, using the format set
	 * by the attached formatter. The exception stack trace
	 * is logged
	 */
	@Override
	public void log(Level logLevel, String component, Throwable t) throws LoggerException {
		if (currLevel.permitsLogging(logLevel))

		{
			StringWriter sw = new StringWriter();
			t.printStackTrace(new PrintWriter(sw));
			String exceptionDetails = sw.toString();

			LocalDateTime now = LocalDateTime.now();
			LogMessage logMsg = new LogMessage(logLevel, now, component, exceptionDetails);
			String lb = System.getProperty("line.separator");
			String logStr = formatter.format(logMsg);

			try {
				outFile = new FileWriter(new File("log.txt"), true);
				outFile.write(logStr);

				outFile.close();
			} catch (IOException e) {
				throw new LoggerException("could not log to file", e);
			}
		}
	}

}
