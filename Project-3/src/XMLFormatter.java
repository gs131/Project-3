/**
 * A Formatter that produces log messages as XML encoded strings
 * @author Gaganajit Singh 
 *
 */
public class XMLFormatter implements Formatter {

	/**
	 * formats a log message into an XML string
	 */
	@Override
	public String format(LogMessage logMsg) {
		String lb = System.getProperty("line.separator");
        String retStr = "<LogMsg>" + lb;
        retStr = retStr + "<Level>" + logMsg.getLevel() +  "</Level>" + lb;
        retStr = retStr + "<DateTime>" + logMsg.getDateTime() + "</DateTime>" + lb;
        retStr = retStr + "<Component>" + logMsg.getComponent() + "</Component>" + lb;
        retStr = retStr + "<Msg>" + logMsg.getMsg() + "</Msg>" + lb;
        retStr = retStr + "</LogMsg>" + lb;
		return retStr;
	}

} 
 