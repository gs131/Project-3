/**
 * this represents the log levels
 * @author Gaganajit Singh
 *
 */
public enum Level {
  SEVERE(4), ERROR(3), WARNING(2), INFO(1), DEBUG(0);
  
  private int value;
  
  private Level(int val)
  {
	  value = val;
  }
  
  public boolean permitsLogging(Level logLevel)
  {
	  if (value <= logLevel.value)
		  return true;
	  else
		  return false;
  }
  
  public String toString()
  {
	  String ret;
	  switch (value) {
	  case 0: ret = "DEBUG";
	          break;
	  case 1: ret = "INFO";
	          break;
	  case 2: ret = "WARNING";
	          break;
	  case 3: ret = "ERROR";
	          break;
	  case 4: ret = "SEVERE";
	          break;
	  default: ret = "";
	  
	  }
	   return ret;
  }
}
