package site.byteToByte;

import java.util.Arrays;
//https://leetcode.com/problems/valid-anagram/
//bytetobyte also
public class Anagrams {

    //What if the inputs contain unicode characters? How would you adapt your solution to such case?
    //taking 256 char array solve the case.
    public boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        int[] letters = new int[1<<8];//256

        for (char c : s1.toCharArray()) {
            letters[c]++;
        }

        for (char c: s2.toCharArray()) {
            letters[c]--;
        }

        for (int i : letters) {
            if (i != 0) return false;
        }

        return true;
    }

    //only takes into consideration 26 smallcases characters
    //Time complexity : O(nlogn),,, sorting costs O(n \log n)O(nlogn) and comparing two strings costs O(n)O(n)
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }

    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isAnagram4(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] letters = new int[1<<8];
        System.out.println(letters.length);
        System.out.println();
    }
}
