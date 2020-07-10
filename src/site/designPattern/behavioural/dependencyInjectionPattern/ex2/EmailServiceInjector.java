package site.designPattern.behavioural.dependencyInjectionPattern.ex2;

public class EmailServiceInjector implements MessageServiceInjector {

    @Override
    public Consumer getConsumer() {
        return new MyDIApplication(new EmailServiceImpl());
    }

}
