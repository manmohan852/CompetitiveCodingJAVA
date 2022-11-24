package site.leetcode.string;
//https://leetcode.com/problems/count-substrings-with-only-one-distinct-letter/
public class CountSubstringsWithOnlyOneDistinctLetter {

    public static int countLetters(String S) {
        if (S == null || S.length() == 0) return 0;
        int count = 1;
        int sum = 0;
        for (int i = 0; i < S.length() - 1; i++) {
            if (S.charAt(i) != S.charAt(i+1)) {
                sum += count * (count + 1) / 2;
                count = 1;
            } else {
                count++;
            }
        }
        sum += count * (count + 1) / 2; // add last substring
        return sum;
    }

    public static void main(String[] args) {
        String s1 = "aaaaaaaaaa";
        String s2 = "aaaba";
        countLetters(s2);
    }
}
