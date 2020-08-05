package site.leetcode.bits;

import java.math.BigInteger;

//https://leetcode.com/articles/add-binary/
public class AddBinary {

    //Time complexity: O(max(N,M)), where N and M are lengths of the input strings a and b.
    //Space complexity: O(max(N,M)) to keep the answer.
    public static String addBinary(String a, String b) {
        int n = a.length(), m = b.length();
        if (n < m) return addBinary(b, a);
        int L = Math.max(n, m);
        StringBuilder sb = new StringBuilder();
        int carry = 0, j = m - 1;
        for(int i = L - 1; i > -1; --i) {
            if (a.charAt(i) == '1') ++carry;
            if (j > -1 && b.charAt(j--) == '1') ++carry;

            if (carry % 2 == 1) sb.append('1');
            else sb.append('0');
            carry /= 2;
        }
        if (carry == 1) sb.append('1');
        sb.reverse();
        return sb.toString();
    }

    //Time complexity : O(N+M), where N and M are lengths of the input strings a and b.
    //Space complexity : O(max(N,M)) to keep the answer.
    public static String addBinary2(String a, String b) {
        BigInteger x = new BigInteger(a, 2);
        BigInteger y = new BigInteger(b, 2);
        BigInteger zero = new BigInteger("0", 2);
        BigInteger carry, answer;
        while (y.compareTo(zero) != 0) {
            answer = x.xor(y);
            carry = x.and(y).shiftLeft(1);
            x = answer;
            y = carry;
        }
        return x.toString(2);
    }
}
