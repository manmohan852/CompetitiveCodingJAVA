package site.byteToByte;

public class Sum {

    public int sum(int a, int b) {
        if (b == 0) return a;
        int partialSum = a ^ b;
        int carry = (a & b) << 1;
        return sum(partialSum, carry);
    }
}
