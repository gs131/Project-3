/**
 * represents an error condition within the logging package
 * @author Gaganajit Singh
 *
 */
public class LoggerException extends Exception {
      public LoggerException (String msg, Throwable t){
    	  super(msg, t);
      }
}
