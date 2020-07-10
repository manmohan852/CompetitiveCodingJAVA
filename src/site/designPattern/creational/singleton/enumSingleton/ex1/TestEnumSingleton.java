package site.designPattern.creational.singleton.enumSingleton.ex1;

public class TestEnumSingleton {


//    Pros:
//    An Instance is thread-safe. and no problem of Serializable[which created new instance]
//     Cons:
//      Not create an instance when required (Eager initialization)
//      By default, enums do not support lazy loading.
//      Cannot convert your singleton to multi-ton, enum would not allow this.

    public static void main(String[] args) {
        SessionFactory sessionFactory = SessionFactory.SESSION_FACTORY;
        sessionFactory.doSomething();

        System.out.println();

        SessionFactory.SESSION_FACTORY.doSomething();
    }
}
