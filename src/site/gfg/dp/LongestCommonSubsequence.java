package site.gfg.dp;

//https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
public class LongestCommonSubsequence {

    //Time complexity of the above naive recursive approach is O(2^n)
    int lcs(char[] X, char[] Y, int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        if (X[m - 1] == Y[n - 1])
            return 1 + lcs(X, Y, m - 1, n - 1);
        else
            return Math.max(lcs(X, Y, m, n - 1), lcs(X, Y, m - 1, n));
    }


    //Time Complexity is O(mn)
    int lcsDP(char[] X, char[] Y, int m, int n) {
        int L[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (X[i - 1] == Y[j - 1])
                    L[i][j] = L[i - 1][j - 1] + 1;
                else
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
            }
        }
        return L[m][n];
    }

    //Time Complexity is O(mn)
    static void printLCS(String X, String Y, int m, int n) {
        int[][] L = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (X.charAt(i - 1) == Y.charAt(j - 1))
                    L[i][j] = L[i - 1][j - 1] + 1;
                else
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
            }
        }

        int index = L[m][n];
        int temp = index;

        char[] lcs = new char[index];
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                lcs[index - 1] = X.charAt(i - 1);
                i--;
                j--;
                index--;
            } else if (L[i - 1][j] > L[i][j - 1])
                i--;
            else
                j--;
        }
        System.out.print("LCS of " + X + " and " + Y + " is ");
        for (int k = 0; k <= temp; k++)
            System.out.print(lcs[k]);
    }

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        char[] X = s1.toCharArray();
        char[] Y = s2.toCharArray();
        int m = X.length;
        int n = Y.length;

        System.out.println("Length of LCS is" + " " +
                lcs.lcs(X, Y, m, n));
    }

}

