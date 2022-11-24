package site.designPattern.behavioural.strategy.ex2;

public class EmailNotification implements Notification {
    @Override
    public void sendMessage(String message) {
//        String emailId = getEmailId(developer);
//        String emailBody = constructEmailBody(emailId, message);
//        emailClient.send(emailBody, emailId);
    }

    private String constructEmailBody(String emailId, String message) {
        // constructs SMS template
        return "";
    }
}