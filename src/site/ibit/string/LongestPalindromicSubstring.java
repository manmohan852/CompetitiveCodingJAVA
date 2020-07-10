package site.ibit.string;

//https://www.interviewbit.com/problems/longest-palindromic-substring/
public class LongestPalindromicSubstring {

    private static int start, end, maxLength;

    // finds the longest palindrome with [left, right] as center
    private static void checkPalindrome(String A, int left, int right) {
        while (left >= 0 && right < A.length() && A.charAt(left) == A.charAt(right)) {
            if (right - left + 1 > maxLength) {
                start = left;
                end = right + 1;
                maxLength = right - left + 1;
            }
            left--;
            right++;
        }
    }

    public static String longestPalindrome(String A) {
        start = 0;
        end = 0;
        maxLength = 0;
        for (int i = 0; i < A.length(); i++) {
            checkPalindrome(A, i, i); // odd length, center in i
            checkPalindrome(A, i, i + 1); // even length, center between i and i + 1
        }
        return A.substring(start, end);
    }

    public static void main(String[] args) {
        String str = "aaaabaaa";
        longestPalindrome(str);

    }
}
