package site.ibit.ninza;

public class LCPrefix {
    public static int LCPrefixCode(String[] A, int K) {
        int n = A.length;
        String[][] dp = new String[n+1][n+1];
        int count = 0;
        for(int i = 1;i<=n;i++){
            dp[i][i] = A[i-1];
            if(A[i-1].length() >= K){
                count += 1;
            }
        }
        for(int i=1;i<=n;i++){
            for(int j=i+1;j<=n;j++){
                dp[i][j] = getCommonPrefix(dp[i][j-1],A[j-1]);
                if(dp[i][j].length() >= K){
                    count+=1;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] A = {"ab","ac","bc"};
        int B = 1;
        LCPrefixCode(A,B);
    }

     static String getCommonPrefix(String str1, String str2) {
        String result = "";
        int n1 = str1.length(), n2 = str2.length();
        if(n1 == 0 || n2 == 0){
            return "";
        }

        // Compare str1 and str2
        for (int i = 0, j = 0; i <= n1 - 1 && j <= n2 - 1; i++, j++) {
            if (str1.charAt(i) != str2.charAt(j)) {
                break;
            }
            result += str1.charAt(i);
        }

        return (result);
    }
}
