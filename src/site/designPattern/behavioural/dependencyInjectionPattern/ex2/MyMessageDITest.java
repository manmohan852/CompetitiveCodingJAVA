package site.designPattern.behavioural.dependencyInjectionPattern.ex2;
//https://www.journaldev.com/2394/java-dependency-injection-design-pattern-example-tutorial
public class MyMessageDITest {

    public static void main(String[] args) {
        String msg = "Hi Pankaj";
        String email = "pankaj@abc.com";
        String phone = "4088888888";

        MessageServiceInjector injector = null;
        Consumer app = null;

        //Send email
        injector = new EmailServiceInjector();
        app = injector.getConsumer();
        app.processMessages(msg, email);

        //Send SMS
        injector = new SMSServiceInjector();
        app = injector.getConsumer();
        app.processMessages(msg, phone);
    }

//    Some of the benefits of using Dependency Injection in Java are:
//
//    Separation of Concerns
//    Boilerplate Code reduction in application classes because all work to initialize dependencies is handled by the injector component
//    Configurable components makes application easily extendable
//    Unit testing is easy with mock objects

}
