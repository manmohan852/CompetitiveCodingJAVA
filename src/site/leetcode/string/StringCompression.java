package site.leetcode.string;

//https://leetcode.com/problems/string-compression/
public class StringCompression {

    public static void main(String[] args) {
        char[] strArr = {'a','a','b','b','c','c','c'}; //ans = 6
        compress(strArr);


    }

    public static int compress(char[] chars) {
        int anchor = 0, write = 0;
        for (int read = 0; read < chars.length; read++) {
            if (read + 1 == chars.length || chars[read + 1] != chars[read]) {
                chars[write++] = chars[anchor];
                if (read > anchor) {
                    for (char c: ("" + (read - anchor + 1)).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                anchor = read + 1;
            }
        }
        return write;
    }

}
