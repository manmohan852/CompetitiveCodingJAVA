package site.leetcode.string;

import java.util.Arrays;
//https://leetcode.com/problems/multiply-strings/
public class MultiplyStrings {

    public static String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();

        if(len2 > len1) return multiply(num2, num1);

        char[] result = new char[len1 + len2];
        Arrays.fill(result, '0');

        for(int i = len2 - 1; i >= 0; i--) {
            char a = num2.charAt(i);
            for(int j = len1 - 1; j >= 0; j--) {
                char b = num1.charAt(j);

                int prod = (a - '0') * (b - '0');

                int temp = (result[i + j + 1] - '0') + (prod);
                result[i + j + 1] = (char)((temp % 10) + '0');

                temp = (result[i + j] - '0') + (temp / 10);
                result[i + j] = (char)((temp) + '0');
            }
        }

        StringBuilder sb = new StringBuilder();
        boolean numSeen = false;

        for(char c : result) {
            if(c - '0' > 0) numSeen = true;
            if(numSeen) sb.append(c);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        String s1= "123";
        String s2 = "456";
        multiply(s1,s2);
    }
}
