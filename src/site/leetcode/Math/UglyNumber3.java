package site.leetcode.Math;
//https://leetcode.com/problems/ugly-number-iii/
//https://leetcode.com/problems/ugly-number-iii/discuss/387780/JavaC%2B%2B-Binary-Search-with-Venn-Diagram-Explain-Math-Formula
public class UglyNumber3 {
    int MAX_ANS = (int) 2e9; // 2*10^9
    public int nthUglyNumber(int n, int a, int b, int c) {
        int left = 0, right = MAX_ANS, result = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (count(mid, a, b, c) >= n) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
    int count(long num, long a, long b, long c) {
        return (int) (num / a + num / b + num / c
                - num / lcm(a, b)
                - num / lcm(b, c)
                - num / lcm(a, c)
                + num / (lcm(a, lcm(b, c))));
    }
    long gcd(long a, long b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
    long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    public static void main(String[] args) {
        UglyNumber3 uglyNumber3 = new UglyNumber3();
        uglyNumber3.nthUglyNumber(3,2,3,5);//ans = 4
    }
}