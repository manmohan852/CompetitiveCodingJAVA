package site.designPattern.creational.factory.ex3.factory;
//https://medium.com/@kousiknath/design-patterns-different-approaches-to-use-factory-pattern-to-choose-objects-dynamically-at-run-71449bceecef
class LoggerFactory {
    public static LoggingOperation getInstance(String loggerMedium) {
        LoggingOperation op = null;
        switch (loggerMedium) {
            case "MEMORY":
                op = new InMemoryLog();
                break;
            case "FILE":
                op = new FileLog();
                break;
            case "DB":
                op = new DBLog();
                break;
            case "REMOTE_SERVICE":
                op = new RemoteServiceLog();
                break;
                //extending
//            case "FLASH_DRIVE":
//                op = new FlashDriveLog();
//                break;
        }

        return op;
    }
}
//    You want to add a new storage medium like FLASH_DRIVE,
//        just create a new class which implements LoggingOperation interface
//& register it to the LoggerFactory with proper parameter.
//        This is how factory pattern can help you dynamically choosing an implementation