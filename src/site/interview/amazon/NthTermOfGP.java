package site.interview.amazon;

public class NthTermOfGP {

    public static double nthTerm(double input1, double input2, int input3) {
        double r = input2 / input1;
        double a = input1 / r;
        return a * Math.pow(r,input3-1);
    }

    public static void main(String[] args) {
        nthTerm(2,3,5);
    }
}
