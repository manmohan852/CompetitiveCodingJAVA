package site.leetcode.string;

//https://leetcode.com/problems/regular-expression-matching/
public class RegularExpressionMatching {

    public static boolean isMatch1(String s, String p) {
        return s.matches(p);
    }

    public static boolean isMatch2(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();
        boolean first_match = (!text.isEmpty() && (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            return (isMatch2(text, pattern.substring(2)) || (first_match && isMatch2(text.substring(1), pattern)));
        } else {
            return first_match && isMatch2(text.substring(1), pattern.substring(1));
        }
    }

    public static void main(String[] args) {
        //case 1
        String s = "";
        String p = "";
        isMatch2(s, p);
    }
}