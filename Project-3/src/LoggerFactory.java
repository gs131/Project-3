/**
 * This exists to create instances of Loggers
 * @author Gaganajit Singh
 *
 */
public class LoggerFactory {
	enum LogType { FILE, CONSOLE}
	/**
	 * return a Logger instance whose type corresponds
	 * to the string passed in
	 * @param type the type of logger requested
	 * @return a logger instance
	 */
    static public SimpleLogger getLogger(LogType type)
    {
    	if (type.equals(LogType.FILE))
    		return FileLogger.getInstance();
    	else if (type.equals(LogType.CONSOLE))
    		return ConsoleLogger.getInstance();
    	return null;
    }
}
