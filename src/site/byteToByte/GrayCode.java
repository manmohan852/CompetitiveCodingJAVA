package site.byteToByte;

public class GrayCode {

    public static boolean gray(int a, int b) {
        int x = a ^ b;
        while (x > 0) {
            if (x % 2 == 1 && x>>1 > 0) return false;
            x = x>>1;
        }
        return true;
    }

    public static boolean gray2(int a, int b) {
        int x = a ^ b;
        return (x & (x-1)) == 0;
    }
}
