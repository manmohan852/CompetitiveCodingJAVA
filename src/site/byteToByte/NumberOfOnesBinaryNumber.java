package site.byteToByte;

public class NumberOfOnesBinaryNumber {

    public int ones(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x & 1;
            x >>= 1;
        }
        return sum;
    }

}
