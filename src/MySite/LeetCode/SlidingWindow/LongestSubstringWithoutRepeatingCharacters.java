package MySite.LeetCode.SlidingWindow;

import java.util.HashSet;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {

    }
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int l = 0;
        int r = 0;
        HashSet<Character> hs = new HashSet<>();
        int maxLen = 0;
        while(r < n){
            if(!hs.contains(s.charAt(r))){
                hs.add(s.charAt(r));
                maxLen = Math.max(maxLen, r - l + 1);
                r++;

            }
            else {
                hs.remove(s.charAt(l));
                l++;
            }
        }
        return maxLen;
    }
}
