package site.designPattern.creational.singleton.ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LimitClass2 {

    private static List<LimitClass2> ObjectPool = new ArrayList<>();
    public static int objCount = 0;
    private static Random randomizer = new Random();

    private LimitClass2(){
        objCount++;
    }
    public static synchronized LimitClass2 getLimInstance(){
        if(objCount < 3 ){
            LimitClass2 lc = new LimitClass2();
            ObjectPool.add(lc);
            return lc;
        }
        //randomizer.nextInt())%3 gives output between [-2 to +2] ends inclusive.
        return ObjectPool.get(Math.abs(randomizer.nextInt())%3);
    }
}
