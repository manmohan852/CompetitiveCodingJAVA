package site.designPattern.creational.singleton.enumSingleton.ex2;


public class SingletonTest {

    public static void main(String[] args) {
        ProcessCount.INSTANCE.setCount(1);
        ProcessCount.INSTANCE.doProcess();
        ProcessCount.INSTANCE.setCount(2);
        ProcessCount.INSTANCE.doProcess();
        ProcessCount.INSTANCE.doProcess();
    }
}
