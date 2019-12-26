/**
 * Represents one log message
 * A log message consists of the log level, the time and date of 
 * the message, the component in which the message was generated
 * and the message itself
 */

import java.time.LocalDateTime;

/**
 * One log message, produced by the logger
 * Its components are the log level, a date/time representing
 * the time the log message was produced, a string representing
 * the program component (class name) where the log message
 * was generated, and a message to be logged.
 * @author Gaganajit Singh
 *
 */
public class LogMessage {
	private Level level;
	private LocalDateTime dateTime;
	private String component;
	private String msg;
	
	public LogMessage(Level level, LocalDateTime dateTime, String component, String msg) {
		this.level = level;
		this.dateTime = dateTime;
		this.component = component;
		this.msg = msg;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public String getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = component;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	

}
