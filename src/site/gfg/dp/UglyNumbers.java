package site.gfg.dp;

public class UglyNumbers {

    static int maxDivide(int a,int b){
        while(a % b ==0){
            a= a/b;
        }
        return a;
    }

    static boolean isUgly(int num){
        num = maxDivide(num,2);
        num = maxDivide(num,3);
        num = maxDivide(num,5);

        return num == 1? true: false;
    }

    static int getNthUglyNumber(int n){
        int i=1;
        int count =1;
        while(n> count){
            i++;
            if(isUgly(i)){
                count++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(getNthUglyNumber(150));
    }
}
