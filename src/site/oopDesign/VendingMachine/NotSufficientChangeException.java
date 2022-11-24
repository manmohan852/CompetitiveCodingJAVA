package site.oopDesign.VendingMachine;

public class NotSufficientChangeException extends RuntimeException{
    public String message;

    public NotSufficientChangeException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}