package site.javaTest.basics.staticClass;

//https://www.baeldung.com/java-static
public class StaticClass {
    static int a = m1();

    static {
        System.out.println("Inside static block");
    }

    static int m1() {
        System.out.println("from m1");
        return 20;
    }

    public static void main(String[] args) {
        System.out.println("Value of a : " + a);
        System.out.println("from main");
    }
}
