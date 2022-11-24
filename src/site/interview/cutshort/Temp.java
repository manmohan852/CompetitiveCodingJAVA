package site.interview.cutshort;

class MyThread extends Thread {
    MyThread() {
        System.out.print(" Thread");
    }

    public void run() {
        System.out.print(" 2");
    }

    public void run(String s) {
        System.out.println(" 3");
    }
}

public class Temp {
    public static void main(String[] args) {
        Thread t = new MyThread() {
            public void run() {
                System.out.println(" 1");
            }
        };
        t.start();
    }
}