package site.designPattern.behavioural.dependencyInjectionPattern.ex1;

public class MyApplication {

    private EmailService email = new EmailService();

    public void processMessages(String msg, String rec){
        //do some msg validation, manipulation logic etc
        this.email.sendEmail(msg, rec);
    }
}
