package site.designPattern.behavioural.dependencyInjectionPattern.ex2;

public class SMSServiceInjector implements MessageServiceInjector {

    @Override
    public Consumer getConsumer() {
        return new MyDIApplication(new SMSServiceImpl());
    }

}