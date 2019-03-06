package site.gfg.divideAndConquer;

public class CalculatePowerXtoN {
    public static void main(String[] args) {
        int x = 2;int y = 3;
        System.out.printf("%d",power(x,y));
    }

    public static int power(int a, int b){
        if(b==0){
            return 1;
        }
        else if(b % 2 == 0){
            return power(a, b/2) * power(a,b/2);
        }
        else
            return a * power(a,b/2) * power(a, b/2);
    }
}
