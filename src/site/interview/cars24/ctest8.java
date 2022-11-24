package site.interview.cars24;

import java.util.ArrayList;

public class ctest8 {
    public static void main(String[] args) {
//        HackerEarth2 obj = new HackerEarth2();
//        obj.func();

//        ArrayList<String> h = new ArrayList<>();
//        System.out.println(h.size());
//        h.add("h");
//        h.add("a");
//        h.add("c");
//        h.add(1,"k");
//        System.out.println(h.size());
//        h.remove("a");
//        h.remove(2);
//        System.out.println(h.size());

//        int n;
//        for (int i =0;i<5;i++){
//            n = getValue();
//            assert n >2;
//            System.out.println(" " + n);
//        }
//    }
//    static  int val = 3;
//    static int getValue(){
//        return val--;

//        Integer var1 = Integer.valueOf(34);
//        Integer var2 = Integer.valueOf(34);
//        System.out.println("" + (var1 == var2));
//        System.out.println("" + var1.equals(var2));

//        StringBuilder sb = new StringBuilder();
//        sb.append("aaa").insert(1,"bb").insert(4,"ccc");
//        System.out.println(sb);

//        String str = "Hacking";
//        LanfFunc lf = () -> System.out.println(str + "Java");
//        str= "ay";
//        lf.callMe();

//        "hackerearth".chars().distinct().peek(ch -> System.out.println(ch)).sorted();
        String anmes = new String("Alice,BOb,Smith");
        anmes = anmes.replaceAll(",",":");
        System.out.println(anmes);
    }

}

interface LanfFunc{
    void callMe();
}

class HackerEarth2{
    void func(){
        try {
            String str = null;
            System.out.println("1");
            try {
                System.out.println(str.length());
            } catch (Exception e) {
                System.out.println("inner");
            }
            System.out.println("2");
        }
        catch (NullPointerException e){
            System.out.println("outer");
        }

    }
}
