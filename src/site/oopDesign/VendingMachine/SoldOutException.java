package site.oopDesign.VendingMachine;

public class SoldOutException extends RuntimeException {
    public String message;

    public SoldOutException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

