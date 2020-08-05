package site.leetcode.bits;

public class ReverseBits {

    public static int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans <<= 1;
            ans = ans | (n & 1);
            n >>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int  i = 43261596;
        int  i2 = -3;
        Integer ii = i;
        reverseBits(ii);
    }

}
