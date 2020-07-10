package site.designPattern.creational.factory.ex3.factory;

public class FlashDriveLog implements LoggingOperation {

    static {
        LoggerFactory2.register("FLASH_DRIVE_LOG", new FlashDriveLog());
    }

    @Override
    public void log(String message) {
        System.out.println("logging to flash drive");
    }
}
