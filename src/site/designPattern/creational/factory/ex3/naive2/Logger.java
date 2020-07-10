package site.designPattern.creational.factory.ex3.naive2;

public class Logger {
    private InMemoryLog mLog;
    private FileLog fLog;
    private DBLog dbLog;
    private RemoteServiceLog sLog;

    public Logger() {
        mLog = new InMemoryLog();
        fLog = new FileLog();
        dbLog = new DBLog();
        sLog = new RemoteServiceLog();
    }

    public void log(String message, String loggerMedium) {
        if (loggerMedium.equals("MEMORY")) {
            mLog.log(message);
        } else if (loggerMedium.equals("FILE")) {
            fLog.log(message);
        } else if (loggerMedium.equals("DB")) {
            dbLog.log(message);
        } else if (loggerMedium.equals("REMOTE_SERVICE")) {
            sLog.log(message);
        }
    }
}

//TIGHTLY COUPLED AND NOT EXTENSIBLE
//In this implementation, we have separated out the individual code into their corresponding files,
//        but our Logger class is tightly coupled with the instances of the storage mediums like FileLog, DBLog etc.
//        With more additions of storage medium, more instance will be introduced in the Logger class.