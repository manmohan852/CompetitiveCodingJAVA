package site.leetcode.string;

import java.util.*;

//https://leetcode.com/problems/word-break-ii/
public class WordBreak2 {

    Map<String, List<String>> memo = new HashMap<>();

    //TOP DOWN - MEMO
    //DFS with Memoizations
    public List<String> wordBreak(String s, List<String> wordDict) {
        if (memo.containsKey(s)) return memo.get(s);
        List<String> res = new ArrayList<>();
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                if (s.length() == word.length())
                    res.add(word);
                else {
                    List<String> sub = wordBreak(s.substring(word.length()), wordDict);
                    for (String w : sub)
                        res.add(word + " " + w);
                }
            }
        }
        memo.put(s, res);
        return memo.get(s);
    }

    //DFS with Memoizations
    public List<String> wordBreak2(String s, List<String> wordDict) {
        List<String> result = new ArrayList();
        if(isWordBreak(s, wordDict))
            wb(s, "", new HashSet<>(wordDict), result);
        return result;
    }

    private void wb(String s, String sent, Set<String> wordDict, List<String> result) {
        if(s.isEmpty()) {
            result.add(sent.trim());
            return;
        }

        for(int i = 1; i <= s.length(); i++) {
            if(wordDict.contains(s.substring(0, i))) {
                wb(s.substring(i), sent + s.substring(0, i) + " ", wordDict, result);
            }
        }
    }

    public boolean isWordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 0; j < i; j++) {
                if(wordDict.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
