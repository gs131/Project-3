
/**
 * Represents all Logger implementations
 * @author Gaganajit Singh
 *
 */

public abstract class SimpleLogger {
	protected Level currLevel = Level.ERROR;
	protected Formatter formatter;

	/**
	 * set the log level
	 * 
	 * @param l
	 */
	public void setLevel(Level l) {
		currLevel = l;
	}

	public Level getLevel() {
		return currLevel;
	}

	/**
	 * associate a formatter with the logger
	 * 
	 * @param f a formatter
	 */
	public void setFormatter(Formatter f) {
		formatter = f;
	}

	/**
	 * Generate a log message and write it to the appropriate destination
	 * 
	 * @param logLevel
	 * @param component
	 * @param msg
	 * @throws LoggerException
	 */
	public abstract void log(Level logLevel, String component, String msg) throws LoggerException;

	/**
	 * Generate a log message and write it to the appropriate destination This
	 * version expects a Throwable instance and will include the stack trace in the
	 * message.
	 * 
	 * @param error
	 * @param component
	 * @param t         - a Throwable
	 * @throws LoggerException
	 */
	public abstract void log(Level error, String component, Throwable t) throws LoggerException;

}
