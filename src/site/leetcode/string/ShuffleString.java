package site.leetcode.string;

//https://leetcode.com/problems/shuffle-string/
public class ShuffleString {

    public static String restoreString1(String s, int[] indices) {
        StringBuilder res = new StringBuilder(s);
        int l = s.length();
        for (int i = 0; i < l; i++) {
            res.setCharAt(indices[i], s.charAt(i));
        }
        return res.toString();
    }

    public static String restoreString2(String s, int[] indices) {
        char[] r = new char[s.length()];
        for(int i=0;i<s.length();i++) r[indices[i]] = s.charAt(i);
        return new String(r);
    }

    public static String restoreString3(String s, int[] indices) {
        char[] values = new char[s.length()];
        for(int i=0, j=s.length()-1; i<=j; i++, j--){
            if(i==j){
                values[indices[i]] = s.charAt(i);
            }else{
                values[indices[i]] = s.charAt(i);
                values[indices[j]] = s.charAt(j);
            }
        }
        return new String(values);
    }

    public static void main(String[] args) {
        String s = "aiohn";
        int[] indices = {3,1,4,2,0};
        restoreString3(s,indices);
    }

}
