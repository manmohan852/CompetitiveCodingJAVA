package site.designPattern.creational.singleton.enumSingleton.ex2;

public enum ProcessCount {
    //Eager initialization – create an instance when initialize. It might be not required at that moment.
    //Enum created using eager.

    INSTANCE;

    private int count;

    public void setCount(int count) {
        this.count = count;
    }

    public void doProcess() {
        System.out.println("Do high memory or CPU consume operation. count : " + this.count);
    }

}
