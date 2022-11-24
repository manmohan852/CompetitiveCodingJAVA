package site.interview.cutshort;


class Test extends Thread {
    final StringBuffer str1 = new StringBuffer();
    final StringBuffer str2 = new StringBuffer();

    public static void main(String args[]) {
        final Test obj = new Test();

        new Thread() {
            public void run() {
                synchronized (this) {
                    obj.str1.append("1");
                    obj.str2.append("A");
                    System.out.println(obj.str1);
                    System.out.println(obj.str2);
                }
            }
        }.start();

        new Thread() {
            public void run() {
                synchronized (this) {
                    obj.str1.append("2");
                    obj.str2.append("B");
                    System.out.println(obj.str2);
                    System.out.println(obj.str1);
                }
            }
        }.start();
    }
}