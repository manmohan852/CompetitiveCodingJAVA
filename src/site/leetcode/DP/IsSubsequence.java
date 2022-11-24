package site.leetcode.DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//https://leetcode.com/problems/is-subsequence/
public class IsSubsequence {

    //TWO Pointers
    //Time Complexity: O(∣T∣), T: length of the target string
    public static boolean isSubsequence(String s, String t) {
        Integer leftBound = s.length(), rightBound = t.length();
        Integer pLeft = 0, pRight = 0;

        while (pLeft < leftBound && pRight < rightBound) {
            if (s.charAt(pLeft) == t.charAt(pRight)) {
                pLeft += 1;
            }
            pRight += 1;
        }
        return pLeft == leftBound;
    }

    //Time Complexity: O(∣T∣), T: length of the target string
    static boolean isSubSequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int j = 0;
        for (int i = 0; i < n && j < m; i++)
            if (str1.charAt(j) == str2.charAt(i))
                j++;
        return (j == m);
    }

    //Recursion
    static boolean isSubSequenceRecur(String str1, String str2, int m, int n) {
        if (m == 0)
            return true;
        if (n == 0)
            return false;
        if (str1.charAt(m - 1) == str2.charAt(n - 1))
            return isSubSequenceRecur(str1, str2, m - 1, n - 1);
        return isSubSequenceRecur(str1, str2, m, n - 1);
    }


    //DP
    //Time Complexity:  O(∣S∣⋅∣T∣)
    public boolean isSubsequence2(String s, String t) {
        Integer sourceLen = s.length(), targetLen = t.length();
        if (sourceLen == 0)
            return true;
        int[][] dp = new int[sourceLen + 1][targetLen + 1];
        for (int col = 1; col <= targetLen; ++col) {
            for (int row = 1; row <= sourceLen; ++row) {
                if (s.charAt(row - 1) == t.charAt(col - 1))
                    dp[row][col] = dp[row - 1][col - 1] + 1;
                else
                    dp[row][col] = Math.max(dp[row][col - 1], dp[row - 1][col]);
            }
            if (dp[sourceLen][col] == sourceLen)
                return true;
        }
        return false;
    }

    //HashMap
    //Time Complexity:  O(∣S∣⋅∣T∣)
    public boolean isSubsequence3(String s, String t) {
        HashMap<Character, List<Integer>> letterIndicesTable = new HashMap<>();
        for (int i = 0; i < t.length(); ++i) {
            if (letterIndicesTable.containsKey(t.charAt(i)))
                letterIndicesTable.get(t.charAt(i)).add(i);
            else {
                ArrayList<Integer> indices = new ArrayList<Integer>();
                indices.add(i);
                letterIndicesTable.put(t.charAt(i), indices);
            }
        }
        Integer currMatchIndex = -1;
        for (char letter : s.toCharArray()) {
            if (!letterIndicesTable.containsKey(letter))
                return false;
            boolean isMatched = false;
            for (Integer matchIndex : letterIndicesTable.get(letter)) {
                if (currMatchIndex < matchIndex) {
                    currMatchIndex = matchIndex;
                    isMatched = true;
                    break;
                }
            }
            if (!isMatched)
                return false;
        }
        return true;
    }


    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "ahbgdc";
        String str3 = "axc";
        isSubsequence(str1, str2);
        isSubsequence(str3, str2);
    }
}
