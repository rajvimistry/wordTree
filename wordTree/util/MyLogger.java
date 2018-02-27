package wordTree.util;

public class MyLogger{

    /*DEBUG_VALUE=4 [Print to stdout everytime a constructor is called]
      DEBUG_VALUE=3 [Print to stdout everytime the thread's RUN method is called]
      DEBUG_VALUE=2 [Print to stdout everytime when file is being opened to read or write]
      DEBUG_VALUE=1 [Print to stdout everytime when new node is created]
      DEBUG_VALUE=0 [No output should be printed from the applicatio to stdout. It is ok to write to the output file though" ]
    */

    public static enum DebugLevel {RELEASE, NODE_CREATE, FILE_OPEN, THREAD_RUN, CONSTRUCTOR
                                   };

    private static DebugLevel debugLevel;


    public static void setDebugValue (int levelIn) {
	switch (levelIn) {
		case 4: debugLevel = DebugLevel.CONSTRUCTOR; break;
	      // FIXME: add code for other cases
		case 3: debugLevel = DebugLevel.THREAD_RUN; break;
		case 2: debugLevel = DebugLevel.FILE_OPEN; break;
		case 1: debugLevel = DebugLevel.NODE_CREATE; break;
		case 0: debugLevel = DebugLevel.RELEASE; break;
	}
    }

    public static void setDebugValue (DebugLevel levelIn) {
	debugLevel = levelIn;
    }	

    // @return None
    public static void writeMessage (String  message  ,
                                     DebugLevel levelIn ) {
	if (levelIn == debugLevel)
	    System.out.println(message);
    }

    /**
	 * @return String
	 */
    public String toString() {
	return "Debug Level is " + debugLevel;
    }
}
