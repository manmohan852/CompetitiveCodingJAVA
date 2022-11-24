package site.leetcode.twoPointers;

import java.util.*;

//https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/
public class LongestWordInDictionaryThroughDeleting {
    //Time complexity : O(2^n)
    //Time complexity : O(2^n)
    public static String findLongestWord1(String s, List< String > d) {
        HashSet < String > set = new HashSet < > (d);
        List < String > l = new ArrayList<>();
        generate(s, "", 0, l);
        String max_str = "";
        for (String str: l) {
            if (set.contains(str))
                if (str.length() > max_str.length() || (str.length() == max_str.length() && str.compareTo(max_str) < 0))
                    max_str = str;
        }
        return max_str;
    }
    public static void generate(String s, String str, int i, List < String > l) {
        if (i == s.length())
            l.add(str);
        else {
            generate(s, str + s.charAt(i), i + 1, l);
            generate(s, str, i + 1, l);
        }
    }

    public static boolean isSubsequence(String x, String y) {
        int j = 0;
        for (int i = 0; i < y.length() && j < x.length(); i++)
            if (x.charAt(j) == y.charAt(i))
                j++;
        return j == x.length();
    }

    //Time complexity : O(n⋅xlogn+n⋅x)
    //java compareTo takes O(min(length of two strings))
    //sorting takes : O(n.x.logn)
    //Space Complexity : O(logn). Sorting takes O(logn) space in average case.
    public static String findLongestWord2(String s, List < String > d) {
        Collections.sort(d, new Comparator < String > () {
            public int compare(String s1, String s2) {
                return s2.length() != s1.length() ? s2.length() - s1.length() : s1.compareTo(s2);
            }
        });
        for (String str: d) {
            if (isSubsequence(str, s))
                return str;
        }
        return "";
    }

    //Time complexity : O(n⋅x)
    //Space Complexity : O(x). max_str variable is used.
    public static String findLongestWord3(String s, List < String > d) {
        String max_str = "";
        for (String str: d) {
            if (isSubsequence(str, s)) {
                if (str.length() > max_str.length() || (str.length() == max_str.length() && str.compareTo(max_str) < 0))
                    max_str = str;
            }
        }
        return max_str;
    }


    public static void main(String[] args) {
        List<String> d = new ArrayList<>(Arrays.asList("ale","apple","monkey","plea"));
        findLongestWord3("abpcplea",d);
        "kjnfs".compareTo("hbdf");
    }
}
