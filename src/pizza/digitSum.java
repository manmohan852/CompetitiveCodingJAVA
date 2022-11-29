package pizza;

public class digitSum {
    public static void main(String[] args) {
        int n = 3;
        String s = "111279";
        int ans = solve(n, s);
        System.out.println(ans);
    }
    static int solve(int N, String S){
        int sum1=0;
        int sum2=0;
        for(int i=0; i<N; i++)
        {
            sum1 += Character.getNumericValue(S.charAt(i));
            sum2 += Character.getNumericValue(S.charAt(i+N));
        }
        if((sum1-sum2) % 9 == 0)
            return Math.abs((sum1-sum2)/9);
        else
            return Math.abs((sum1-sum2)/9) + 1;
    }
}
