package site.interview.cars24;

public class ctest2 {
    public static void main(String[] args) {
        Hacker obj = new Hacker();
        obj.display();
    }
}

class HackerEarth{
    protected int var1 = 200;
    private String var2 = "Scala";
}
class Hacker extends HackerEarth{
    public int var1 = 500;
    public String var2 = "Python";

    public void display(){
        System.out.println(""+ var1);
//        System.out.println("" + super.var2);
    }
}
