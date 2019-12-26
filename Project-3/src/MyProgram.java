
// This version logs to the console in CSV format
public class MyProgram {

	public static void main(String[] args) {
		try {
			// the value could also be LoggerFactory.LogType.FILE
			SimpleLogger logger = LoggerFactory.getLogger(LoggerFactory.LogType.CONSOLE);
			// the value could also be Formatter.Format.JSON
			logger.setFormatter(Formatter.getFormatter(Formatter.Format.CSV));
			logger.setLevel(Level.INFO);

			logger.log(Level.INFO, "main", "system starting");

			try {
				double res1 = doDivision(2, 3);
				double res2 = doDivision(3, 0);
			} catch (Exception e) {
                // this calls the second version of logger.log - the one
				// that expects a Throwable (an exception) as the 4th parameter
				logger.log(Level.ERROR, "main", e);
			}
			logger.log(Level.INFO, "main", "system ending");

		} catch (LoggerException e) {
           
			e.printStackTrace();
		}

	}

	private static double doDivision(int i, int j) {
			double res = 0;
			try {
				SimpleLogger logger = LoggerFactory.getLogger(LoggerFactory.LogType.CONSOLE);
				logger.setFormatter(Formatter.getFormatter(Formatter.Format.CSV));
				logger.log(Level.INFO, "doDivision", "entering");

				if (j == 0) {
					throw new IllegalArgumentException("Attempt to divide by  0");
				} else {
					res = i / j;
					logger.log(Level.INFO, "doDivision", "result is " + res);
				}

			} catch (LoggerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return res;
		}

}
