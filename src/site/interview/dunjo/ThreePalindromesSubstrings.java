package site.interview.dunjo;

import java.util.ArrayList;
import java.util.List;

public class ThreePalindromesSubstrings {
    public static List<String> threePalindromesSubstrings2(String word) {
//        List<List<String>> res = new ArrayList<>();
        List<String> result = new ArrayList<>();
        int n = word.length();
        for (int i = 1; i < n - 1; i++) {
            String a = word.substring(0, i);
            for (int j = n - 1; j > i; j--) {
                String b = word.substring(i, j);
                String c = word.substring(j, n);
                if (isPalindrome(a) && isPalindrome(b) && isPalindrome(c)) {
                    List<String> temp = new ArrayList<>();
                    temp.add(a);
                    temp.add(b);
                    temp.add(c);
                    return temp;
                }
            }
        }
        result.add("Impossible");
        return result;
    }

    public static List<String> threePalindromesSubstrings3(String word) {
        List<String> result = new ArrayList<>();
        int n = word.length();
        for (int i = 1; i < n - 1; i++) {
            String a = word.substring(0, i);
            for (int j = i + 1; j < n; j++) {
                String b = word.substring(i, j);
                String c = word.substring(j, n);
                if (isPalindrome(a) && isPalindrome(b) && isPalindrome(c)) {
                    List<String> temp = new ArrayList<>();
                    temp.add(a);
                    temp.add(b);
                    temp.add(c);
                    return temp;
                }
            }
        }
        result.add("Impossible");
        return result;
    }

    //Most time optimized solution, accepted for all test cases on hackerrank
    public static List<String> threePalindromicSubstrings4(String word) {
        List<String> result = new ArrayList<>();
        int n = word.length();
        if(n<3) {
            result.add("Impossible");
            return result;
        }
        for(int i=2;i<n;i++){
            String a = word.substring(i,n);
            if(checkPalindrome(a)){
                for(int j = 1;j<i;j++){
                    String b = word.substring(0,j);
                    String c = word.substring(j,i);
                    if(checkPalindrome(c) && checkPalindrome(b)){
                        result.add(b);
                        result.add(c);
                        result.add(a);
                        return result;
                    }
                }
            }
        }
        result.add("Impossible");
        return result;
    }

    public static boolean checkPalindrome(String s) {
        String reverse = new StringBuffer(s).reverse().toString();
        if (s.equals(reverse))
            return true;
        else
            return false;
    }

    public static boolean isPalindrome(String X) {
        int i = 0;
        int j = X.length() - 1;
        while (i <= j) {
            if (X.charAt(i++) != X.charAt(j--)) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
//        String str = "madamciviclevel";
        String word = "kayakracecartenet";
        String word2 = "madamciviclevel";
        String word3 = "aaaaa";
        threePalindromicSubstrings4(word2);
    }

    public static void main1(String[] args) {
//        String word = "madamciviclevel";//
        String word = "kayakracecartenet";
        String a = word.substring(0, 5);
        String b = word.substring(5, 10);
        String c = word.substring(10, word.length());
        System.out.println();
    }
}
