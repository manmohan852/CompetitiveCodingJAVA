package site.leetcode.string;

import java.util.*;
//https://leetcode.com/problems/word-break/
public class WordBreak {

    //Time complexity : O(n^2)
    public boolean wordBreak(String s, List<String> wordDict) {
        return word_Break(s, new HashSet(wordDict), 0);
    }

    public boolean word_Break(String s, Set<String> wordDict, int start) {
        if (start == s.length()) {
            return true;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && word_Break(s, wordDict, end)) {
                //swapping the two conditions in if
                //increases time complexity from O(n^2) to O(n^n);
                return true;
            }
        }
        return false;
    }

    //Time complexity : O(n^2)
    //Size of recursion tree can go up to n^2
    //Space complexity : O(n). The depth of recursion tree can go up to n.
    public boolean wordBreak1(String s, List<String> wordDict) {
        return word_Break(s, new HashSet(wordDict), 0, new Boolean[s.length()]);
    }

    public boolean word_Break(String s, Set<String> wordDict, int start, Boolean[] memo) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && word_Break(s, wordDict, end, memo)) {
                return memo[start] = true;
            }
        }
        return memo[start] = false;
    }

    //BFS
    //Time complexity : O(n^2)
    //For every starting index, the search can continue till the end of the given string.
    //Space complexity : O(n). Queue of atmost n size is needed.
    public static boolean wordBreak2(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[s.length()];
        queue.add(0);
        while (!queue.isEmpty()) {
            int start = queue.remove();
            if (visited[start] == 0) {
                for (int end = start + 1; end <= s.length(); end++) {
                    if (wordDictSet.contains(s.substring(start, end))) {
                        queue.add(end);
                        if (end == s.length()) {
                            return true;
                        }
                    }
                }
                visited[start] = 1;
            }
        }
        return false;
    }


    //DP
    //Time complexity : O(n^2)
    //Two loops are their to fill dp array.
    //Space complexity : O(n). Length of p array is n+1.
    public boolean wordBreak3(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

}
