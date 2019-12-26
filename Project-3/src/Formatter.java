/**
 * represents all types of Formatters
 * a Formatter determines the format of output
 * log messages
 * @author Gaganajit Singh
 *
 */
public interface Formatter {
	enum Format {CSV, XML, JSON}
	
	/**
	 * produce a string from a log message
	 * in the correct format
	 * @param logMsg
	 * @return a formatted string
	 */
	public String format(LogMessage logMsg);
	
	public  static Formatter getFormatter(Format type) {
		if (type.equals(Format.XML)) {
			return new XMLFormatter();
		}
		else if (type.equals(Format.CSV)) {
			return new CSVFormatter();
		}
		else if (type.equals(Format.JSON)) {
			return new JSONFormatter();
		}
		else
			return null;
	}

}
