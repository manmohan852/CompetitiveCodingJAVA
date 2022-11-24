package site.oopDesign.VendingMachine;

public class NotFullPaidException extends RuntimeException {
    public String message;
    public long remaining;

    public NotFullPaidException(String message, long remaining) {
        super(message);
        this.message = message;
        this.remaining = remaining;
    }

    public long getRemaining() {
        return remaining;
    }

    @Override
    public String getMessage(){
        return message + getRemaining();
    }
}
