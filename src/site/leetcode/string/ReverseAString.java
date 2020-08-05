package site.leetcode.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
//https://leetcode.com/articles/reverse-words-in-a-string/
public class ReverseAString {

    public static String reverseWords(String s) {
        if (s.isEmpty()) return s;
        char[] carr = s.toCharArray();
        int i = 0;
        int j = carr.length - 1;
        while (i <= j && (carr[i] == ' ' || carr[j] == ' ')) {
            if (carr[i] == ' ') {
                i++;
            }
            if (carr[j] == ' ') {
                j--;
            }
        }
        if(i>j) return "";
        String str1 = s.substring(i, j + 1);
        String[] arr = str1.split(" ");
        StringBuilder sb = new StringBuilder();
        for (i = arr.length - 1; i >= 0; i--) {
            if (arr[i].isEmpty()) continue;
            sb.append(arr[i]);
            if (i != 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    //Time complexity: O(N)
    public static String reverseWords2(String s) {
        // remove leading spaces
        s = s.trim();
        // split by multiple spaces
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    public static void main(String[] args) {
        //reverseWords("   the sky is blue  ");
        //reverseWords("a good   example");
        //reverseWords("");
        //reverseWords(" ");
        reverseWords2("   the sky    is         blue  ");
    }
}
