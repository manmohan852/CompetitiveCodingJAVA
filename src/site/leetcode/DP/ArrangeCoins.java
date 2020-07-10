package site.leetcode.DP;

public class ArrangeCoins {

    //Got Memory exhausted error
    public static int arrangeCoins2(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        int i=1;
        int count = 1;
        while(n>=i){
            count++;
            i = i + count;
        }
        return count-1;
    }


    //passed all testcases on leetcode july challenge
    public static int arrangeCoins3(int b) {
        long n = b;
        if(n==0) return 0;
        if(n==1) return 1;
        long i = 1;
        while(i *(i+1) <= 2*n){
            i++;
        }
        return (int) (i-1);
    }

    public static void main(String[] args) {
        int n = 1804289383;
        arrangeCoins3(n);
    }
}
