package site.ibit.Strings;

public class LCSIBIT {
    public  static int[] maxLCS(String A) {
        int n = A.length();
        int count = 0;
        int indexJ = 0;
        for (int j = 1; j < n; j++) {
            String s1 = A.substring(0, j);
            String s2 = A.substring(j, n);
            int mcs = getLCS(s1, s2);
            if (mcs > count) {
                indexJ = j;
                count = mcs;
            }
        }
        int[] res = new int[2];
        res[0] = indexJ;
        res[1] = count;
        return res;
    }

    public static void main(String[] args) {
        String ss = "abba";
        maxLCS(ss);
    }

    public  static int getLCS(String A, String BB) {
        String B = new StringBuilder(BB).reverse().toString();
        System.out.println(B);
        int n = A.length();
        int m = B.length();
        int lcs[][] = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0 || j == 0) {
                    lcs[i][j] = 0;
                } else if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }
        return lcs[n][m];
    }
}