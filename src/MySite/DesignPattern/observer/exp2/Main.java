package MySite.DesignPattern.observer.exp2;
//https://howtodoinjava.com/design-patterns/behavioral/observer-design-pattern/
import MySite.DesignPattern.observer.exp2.*;

public class Main
{
    public static void main(String[] args)
    {
        Observer s1 = new MessageSubscriberOne();
        Observer s2 = new MessageSubscriberTwo();
        Observer s3 = new MessageSubscriberThree();

        MessagePublisher p = new MessagePublisher();

        p.attach((site.designPattern.behavioural.observer.ex2.Observer) s1);
        p.attach((site.designPattern.behavioural.observer.ex2.Observer) s2);

        p.notifyUpdate(new Message("First Message"));   //s1 and s2 will receive the update

        p.detach((site.designPattern.behavioural.observer.ex2.Observer) s1);
        p.attach((site.designPattern.behavioural.observer.ex2.Observer) s3);

        p.notifyUpdate(new Message("Second Message")); //s2 and s3 will receive the update
    }
}
//
//    Program output.
//
//        MessageSubscriberOne :: First Message
//        MessageSubscriberTwo :: First Message
//
//        MessageSubscriberTwo :: Second Message
//        MessageSubscriberThree :: Second Message