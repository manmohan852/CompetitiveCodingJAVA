package site.leetcode.Math;

public class PlusOne {

    public static int[] plusOne(int[] digits) {
        int carry = 1;
        int j = digits.length - 1;
        if (j < 0) return digits;
        while (carry != 0 && j>= 0) {
            int sum = digits[j] + carry;
            digits[j] = sum % 10;
            carry = sum / 10;
            j--;
        }
        int[] newDigits = null;
        if(carry != 0){
            newDigits = new int[digits.length + 1];
            newDigits[0] = carry;
            for (int i = 0;i< digits.length;i++){
                newDigits[i+1] = digits[i];
            }
        }
        return newDigits != null? newDigits : digits;
    }

    public static void main(String[] args) {
        int[] digits = {4, 3, 2, 1};
        int[] digits2 = {1, 2, 3};
        plusOne(digits2);
    }
}
