package site.interview.cars24;

import java.util.Arrays;

public class cars24Test {
    public static void main(String[] args) {
        A obj  = new A();
        obj.cal(2,3);
        System.out.println(obj.x + " " + obj.y);
        String[] testStr = new String[5];
        Arrays.sort(testStr,(s1,s2) ->s1.length() - s2.length());
    }
}

class A{
    public int x;
    public int y;
    void cal(int a, int b){
        x = a+1;
        y = b;
    }
}
