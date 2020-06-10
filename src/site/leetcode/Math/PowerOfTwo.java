package site.leetcode.Math;
//https://leetcode.com/problems/power-of-two/
public class PowerOfTwo {
    //Time complexity : O(1).
    public static boolean isPowerOfTwo2(Integer x) {
        if (x == -2147483648) return false;
        return x != 0 && ((x & (x - 1)) == 0);
    }

    //Time complexity : O(1).
    public static boolean isPowerOfTwo3(int n) {
        if (n == 0) return false;
        long x = n;
        return (x & (-x)) == x;
    }

    //    //    Time complexity : O(log2n). log base is 2
    public static boolean isPowerOfTwo1(int n) {
        if (n == 0) return false;
        while (n % 2 == 0) n /= 2;
        return n == 1;
    }

    static int countSetBits(Integer n) {
        Integer count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSetBits(2147483647));
        System.out.println(Integer.toBinaryString(2147483647));
        String ss = Integer.toBinaryString(2147483647);
        System.out.println(ss.length());
        System.out.println(isPowerOfTwo2(2147483647));
    }
}
