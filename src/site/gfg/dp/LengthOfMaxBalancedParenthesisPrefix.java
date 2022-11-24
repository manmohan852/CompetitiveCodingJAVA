package site.gfg.dp;

//https://www.geeksforgeeks.org/length-longest-balanced-parentheses-prefix/
public class LengthOfMaxBalancedParenthesisPrefix {
    static int maxbalancedprefix(String str, int n) {
        int sum = 0;
        int maxi = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == '(')
                sum += 1;
            else
                sum -= 1;
            if (sum == 0)
                maxi = i + 1;
        }
        return maxi;
    }

    public static void main(String[] args) {
        String str = "((()())())((";
        int n = str.length();
        System.out.println(maxbalancedprefix(str, n));
    }
}

