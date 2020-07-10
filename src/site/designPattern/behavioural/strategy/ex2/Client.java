package site.designPattern.behavioural.strategy.ex2;

import java.util.Map;
//https://blog.usejournal.com/a-deep-dive-into-the-strategy-design-pattern-5723eb3937b4
public class Client {

    private Map<String, Notification> alertNotificationMap;
    private NotificationContext context;

    public Client() {
        alertNotificationMap.put("SMS", new SMSNotification());
        alertNotificationMap.put("EMAIL", new EmailNotification());
    }

    public void sendMessage(String message, String alertType) {
        if (!alertNotificationMap.containsKey(alertType))
            throw new RuntimeException("Notifier not found");
        context.setNotification(alertNotificationMap.get(alertType));
        context.sendNotification(message);

    }
}
