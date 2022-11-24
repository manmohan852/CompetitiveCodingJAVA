package site.designPattern.behavioural.strategy.ex2;

public class NotificationContext {
    private Notification notification;

    public NotificationContext(Notification notification) {
        this.notification = notification;
    }

    public void sendNotification(String message) {
        notification.sendMessage(message);
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }
}
