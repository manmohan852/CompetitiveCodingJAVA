package site.designPattern.behavioural.serviceLocator.ex1;

public class EmailService implements MessagingService {

    public String getMessageBody() {
        return "email message";
    }

    public String getServiceName() {
        return "EmailService";
    }
}

