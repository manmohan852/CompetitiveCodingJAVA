package site.designPattern.creational.factory.ex3.factory;

class Logger {
    public void log(String message, String loggerMedium) {
        LoggingOperation instance = LoggerFactory.getInstance(loggerMedium);
        instance.log(message);
    }
}