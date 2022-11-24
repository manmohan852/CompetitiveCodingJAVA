package site.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/word-subsets/
public class WordSubsets {

    public static List<String> wordSubsets(String[] A, String[] B) {
        int[] bmax = count("");
        for (String b : B) {
            int[] bCount = count(b);
            for (int i = 0; i < 26; ++i)
                bmax[i] = Math.max(bmax[i], bCount[i]);
        }

        List<String> ans = new ArrayList<>();
        for (String a : A) {
            int[] aCount = count(a);
            boolean check = true;
            for (int i = 0; i < 26; ++i) {
                if (aCount[i] < bmax[i]) {
                    check = false;
                    break;
                }
            }
            if (check)
                ans.add(a);
        }

        return ans;
    }

    public static int[] count(String S) {
        int[] ans = new int[26];
        for (char c : S.toCharArray())
            ans[c - 'a']++;
        return ans;
    }

    public static void main(String[] args) {
        String[] A = {"amazon", "apple", "facebook", "google", "leetcode"};
        String[] B = {"e", "oo"};
        wordSubsets(A, B);
    }


}
