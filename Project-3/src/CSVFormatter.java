/**
 * Formats log messages into a string using the CSV format
 * Each record has this format

 * @author Gaganajit Singh
 *
 */
public class CSVFormatter implements Formatter{
    private String lb=System.getProperty("line.separator");
    
	/**
	 * produce a string from a log message
	 * in the JSON format (see class level comment)
	 * @param logMsg
	 * @return a formatted string
	 */
	@Override
	public String format(LogMessage logMsg) {
		String noLineBreakMsg = removeLineBreaks(logMsg.getMsg());
		final String COMMA = ",";

        String retStr = lb;
        retStr = retStr + logMsg.getLevel() +  COMMA;
        retStr = retStr + logMsg.getDateTime() + COMMA;
        retStr = retStr + logMsg.getComponent() + COMMA;
        retStr = retStr + noLineBreakMsg + lb;
		return retStr;
	}

	private String removeLineBreaks(String msg) {
		 String newmsg = msg.replaceAll(lb, "");
		 return newmsg;
	}

}
