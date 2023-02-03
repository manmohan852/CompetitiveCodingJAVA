package MySite.LeetCode.SlidingWindow;
// https://leetcode.com/problems/permutation-in-string/description/
public class permutationinString {
    public static void main(String[] args) {

    }
    public boolean checkInclusion1(String s1, String s2) {
        int L = 0, R = 0, minLen = Integer.MAX_VALUE, counter = 0;
        int[] arr = new int[128];
        char[] s1_arr = s1.toCharArray();
        char[] s2_arr = s2.toCharArray();
        for(char c : s1_arr){
            arr[c]++;
        }
        while(R < s2.length()){
            if(--arr[s2_arr[R]] >= 0){
                counter++;
            }
            while(counter == s1.length()){
                minLen = Math.min(minLen, R - L + 1);
                if(++arr[s2_arr[L]] > 0){
                    counter--;
                }
                L++;
            }
            R++;
        }
        return minLen == s1.length();
    }
    public boolean checkInclusion(String s1, String s2) {
        int L = 0, R = 0, minLen = Integer.MAX_VALUE, counter = 0;
        int[] arr = new int[26];
        for(int i = 0; i < s1.length(); i++){
            arr[s1.charAt(i) - 'a']++;
        }
        while(R < s2.length()){
            if(--arr[s2.charAt(R) - 'a'] >= 0){
                counter++;
            }
            while(counter == s1.length()){
                minLen = Math.min(minLen, R - L + 1);
                if(++arr[s2.charAt(L) - 'a'] > 0){
                    counter--;
                }
                L++;
            }
            R++;
        }
        return minLen == s1.length();
    }
}
