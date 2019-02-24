package site.ibit.dp;

public class Stairs {
    public static int climbstairs(int A){
        int dp[] = new int[A+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i= 3;i<= A;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[A];
    }

    public static void main(String[] args) {
        System.out.println(climbstairs(4));
    }
}
