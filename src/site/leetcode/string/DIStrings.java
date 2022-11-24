package site.leetcode.string;
//https://leetcode.com/problems/di-string-match/
public class DIStrings {

    public static int[] diStringMatch(String S) {
        int N = S.length();
        int lo = 0, hi = N;
        int[] ans = new int[N + 1];
        for (int i = 0; i < N; ++i) {
            if (S.charAt(i) == 'I')
                ans[i] = lo++; //    HERE lo is assigned , then lo++ is saved for next transaction
            else
                ans[i] = hi--;//    HERE hi is assigned , then h-- is saved for next transaction
        }
        ans[N] = lo;
        return ans;
    }

    public static void main(String[] args) {
        String ss = "DIIIID";
        diStringMatch(ss);
    }
}
