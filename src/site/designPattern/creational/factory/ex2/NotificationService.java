package site.designPattern.creational.factory.ex2;
//https://www.geeksforgeeks.org/factory-method-design-pattern-in-java/?ref=rp
public class NotificationService {

    public static void main(String[] args) {
        NotificationFactory notificationFactory = new NotificationFactory();
        Notification notification = notificationFactory.createNotification("SMS");
        notification.notifyUser();
    }
}

