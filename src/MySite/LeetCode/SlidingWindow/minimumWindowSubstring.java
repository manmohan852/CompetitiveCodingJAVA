package MySite.LeetCode.SlidingWindow;
// https://leetcode.com/problems/minimum-window-substring/
public class minimumWindowSubstring {
    public static void main(String[] args) {

    }
    public String minWindow(String s, String t) {
        int counter = 0;
        int L = 0, R = 0, minLen = Integer.MAX_VALUE;
        String ans = "";
        int[] arr = new int[128];
        char[] s_arr = s.toCharArray();
        char[] t_arr = t.toCharArray();
        for(int i = 0; i < t.length(); i++){
            arr[t_arr[i]]++;
        }
        while(R < s.length()){
            if(--arr[s_arr[R]] >= 0){
                counter++;
            }
            while(counter == t.length()){
                int curWin = R - L + 1;
                if(curWin < minLen){
                    minLen = R - L + 1;
                    ans = s.substring(L, R + 1);
                }
                if(++arr[s_arr[L]] > 0){
                    counter--;
                }
                L++;
            }
            R++;
        }
        return ans;
    }
}
