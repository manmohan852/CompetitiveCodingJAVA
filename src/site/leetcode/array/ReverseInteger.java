package site.leetcode.array;
//https://leetcode.com/articles/reverse-integer/
public class ReverseInteger {

    //Range of intger is -2147483648 to 2147483647
    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            //to avoid overflow due to statement rev = rev * 10 + pop;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        //reverse(123);
        reverse(-123);
    }
}
