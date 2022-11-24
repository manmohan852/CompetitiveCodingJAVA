package site.leetcode.string;
//https://leetcode.com/problems/minimum-window-substring/
public class MinimumWindowSubstring {

    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        int[] map = new int[255];
        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i) - 'A']++;
        }
        int st = 0, end = -1, min = Integer.MAX_VALUE;
        int i = 0, j = 0, count = t.length();
        while (j < s.length()) {
            int c = s.charAt(j) - 'A';
            map[c]--;
            if (map[c] >= 0) count--;
            while (count == 0) {
                int k = s.charAt(i) -'A';
                map[k]++;
                if (map[k] > 0) count++;
                if (j - i + 1 < min) {
                    min = j - i + 1;
                    st = i;
                    end = j;
                }
                i++;
            }
            j++;
        }
        return end == -1 ? "" : s.substring(st, end + 1);
    }

    public static void main(String[] args) {
        String S = "ADOBECODEBANC";
        String T = "ABC";
        minWindow(S,T);
    }
}
