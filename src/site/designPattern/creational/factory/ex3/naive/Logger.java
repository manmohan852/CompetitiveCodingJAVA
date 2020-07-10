package site.designPattern.creational.factory.ex3.naive;

public class Logger {
    public void log(String message, String loggerMedium) {
        if (loggerMedium.equals("MEMORY")) {
            logInMemory(message);
        } else if (loggerMedium.equals("FILE")) {
            logOnFile(message);
        } else if (loggerMedium.equals("DB")) {
            logToDB(message);
        } else if (loggerMedium.equals("REMOTE_SERVICE")) {
            logToRemote(message);
        }
    }

    private void logInMemory(String message) {
        // Implementation
    }

    private void logOnFile(String message) {
        // Implementation
    }

    private void logToDB(String message) {
        // Implementation
    }

    private void logToRemote(String message) {
        // Implementation
    }
}
//This Class is not extensible.
//    What happens when you add a different storage medium like FLASH_DRIVE?
//        You will write another method & another if else in the class?
//        With more numbers of mediums, the class is going to explode.