package site.designPattern.creational.singleton.ex2;

public class LimitClass {
    private static LimitClass limInstance;
    public static int objCount = 0;

    private LimitClass(){
        objCount++;
    }

    public static synchronized LimitClass getLimInstance(){
        if(objCount < 3 ){
            limInstance = new LimitClass();//objCount get incremeted each time here due to new
        }
        return limInstance;
    }
}
