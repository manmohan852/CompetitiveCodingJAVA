package site.leetcode.Math;

public class HammingDistance {
    public static int hammingDistance(int x, int y) {
        String xx = Integer.toBinaryString(x);
        String yy = Integer.toBinaryString(y);
        char[] xxArr = xx.toCharArray();
        char[] yyArr = yy.toCharArray();
        int m = xxArr.length;
        int n = yyArr.length;
        int i;
        if (n > m) {
            int temp = n;
            n = m;
            m = temp;
            char[] tempArr = yyArr;
            yyArr = xxArr;
            xxArr = tempArr;
        }
        int diff = m - n;
        if (diff != 0) {
            char[] yyArrNew = new char[m];
            for (i = 0; i < diff; i++) {
                yyArrNew[i] = '0';
            }
            for (i = 0; i < n; i++) {
                yyArrNew[i + diff] = yyArr[i];
            }
            yyArr = yyArrNew;
        }
        int count = 0;
        i = Math.max(m, n) - 1;
        while (i >= 0) {
            if (xxArr[i] != yyArr[i]) {
                count++;
            }
            i--;
        }
        return count;
    }

    public int hammingDistance2(int x, int y) {
        int xor = x ^ y;
        int distance = 0;
        while (xor != 0) {
            distance += 1;
            // remove the rightmost bit of '1'
            xor = xor & (xor - 1);
        }
        return distance;
    }

    public int hammingDistance3(int x, int y) {
        int xor = x ^ y;
        int distance = 0;
        while (xor != 0) {
            if (xor % 2 == 1)
                distance += 1;
            xor = xor >> 1;
        }
        return distance;
    }

    public int hammingDistance4(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public static void main(String[] args) {
        hammingDistance(1, 4);
    }
}
