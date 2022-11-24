package site.designPattern.behavioural.strategy.ex2;


public class SMSNotification implements Notification {
    @Override
    public void sendMessage(String message) {
//        String mobileNumber = getMobileNumber(developer);
//        String smsTemplate = constructSMSTemplate(mobileNumber, message);
//        smsClient.send(smsTemplate, mobileNumber);
    }

    private String constructSMSTemplate(String mobileNumber, String message) {
        // constructs SMS template
        return "";
    }

}
