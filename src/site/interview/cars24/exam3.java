package site.interview.cars24;

public class exam3 {
    public static void main(String[] args) {
        new b2().add();
    }
}

class B1{
    public B1(){}
    private int a = 10;
    protected int b = 30;

    protected  void sum(){
        new B1().get();
    }
    private void get(){
        System.out.println(a+b);
    }
}

class b2 extends B1{
    protected int c= 10;
    protected void add(){
        sum();
    }
}
