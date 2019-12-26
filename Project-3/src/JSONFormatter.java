/**
 * Formats log messages into a string using the JSON format
 * Here is an example of the format
 * {level : INFO,
 *   logdatetime : { year : 2019,
 *   date : 2019-11-24,
 *   time : 15:32:54.028127}
 *   component : main,
 *   message : system starting}
 * @author Bonnie MacKellar
 *
 */
public class JSONFormatter implements Formatter {
	private String lb = System.getProperty("line.separator");

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

		String retStr = "{";
		retStr = retStr + "level : " + logMsg.getLevel() + COMMA + lb;
		
		retStr = retStr + "logdatetime : { year : " + logMsg.getDateTime().getYear() + COMMA + lb;
		retStr = retStr + "date : " + logMsg.getDateTime().toLocalDate() + COMMA + lb;
		retStr = retStr + "time : " + logMsg.getDateTime().toLocalTime() + "}" + lb;
		retStr = retStr + "component : " + logMsg.getComponent() + COMMA + lb;
		retStr = retStr + "message : " + noLineBreakMsg + "}" + lb;
		return retStr;
	}

	private String removeLineBreaks(String msg) {
		String newmsg = msg.replaceAll(lb, "");
		return newmsg;
	}
}
