package site.interview.cars24;

public class ctest6 {
    int a  =9;
    int b = 9;
    private int add(){
        return a+b;
    }
    int result(){
        return new ctest6().add();
    }
    public static void main(String[] args) {
        ctest6 ctest6 = new ctest6();
        System.out.println(2*ctest6.result());
    }
}
