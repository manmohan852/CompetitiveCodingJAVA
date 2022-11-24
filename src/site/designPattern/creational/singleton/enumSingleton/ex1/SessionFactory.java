package site.designPattern.creational.singleton.enumSingleton.ex1;

public enum SessionFactory {
    //Eager initialization – create an instance when initialize. It might be not required at that moment.
    //Enum created using eager.

    SESSION_FACTORY;

    public void doSomething() {
        System.out.println("I am doing something");
    }
}