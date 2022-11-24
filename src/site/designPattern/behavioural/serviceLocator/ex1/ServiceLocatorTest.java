package site.designPattern.behavioural.serviceLocator.ex1;
//https://www.baeldung.com/java-service-locator-pattern
public class ServiceLocatorTest {

    public static void main(String[] args) {
        MessagingService service = ServiceLocator.getService("EmailService");
        String email = service.getMessageBody();
        System.out.println(email);

        MessagingService smsService = ServiceLocator.getService("SMSService");
        String sms = smsService.getMessageBody();
        System.out.println(sms);

        MessagingService emailService = ServiceLocator.getService("EmailService");
        String newEmail = emailService.getMessageBody();
        System.out.println(newEmail);
    }

}
