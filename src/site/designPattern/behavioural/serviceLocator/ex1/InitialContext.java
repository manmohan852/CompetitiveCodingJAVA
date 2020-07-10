package site.designPattern.behavioural.serviceLocator.ex1;

public class InitialContext {

    public Object lookup(String serviceName) {
        if (serviceName.equalsIgnoreCase("EmailService")) {
            return new EmailService();
        } else if (serviceName.equalsIgnoreCase("SMSService")) {
            return new SMSService();
        }
        return null;
    }
}
