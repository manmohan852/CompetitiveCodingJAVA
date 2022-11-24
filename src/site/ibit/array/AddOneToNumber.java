package site.ibit.array;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/add-one-to-number/
public class AddOneToNumber {
    public ArrayList<Integer> plusOne(ArrayList<Integer> a) {
        int i = 0;
        //remove zeroes at the front
        while (i < a.size() - 1 && a.get(i) == 0) {
            a.remove(i);
        }
        int carry = 1;
        int sum;
        for (i = a.size() - 1; i >= 0; i--) {
            sum = a.get(i) + carry;
            a.set(i, sum % 10);
            carry = sum / 10;
            // no need of further processing if carry is zero
            if (carry == 0) {
                break;
            }
        }
        // if carry is still left
        if (carry != 0) {
            a.add(0, carry);
        }
        return a;
    }

    public ArrayList<Integer> plusOne2(ArrayList<Integer> A) {
        int reminder = 0;
        while (A.size() > 1 && A.get(0) == 0) {
            A.remove(0);
        }
        for (int i = A.size() - 1; i >= 0; i--) {
            int num = A.get(i);
            if (num == 9) {
                A.remove(i);
                A.add(i, 0);
                reminder = 1;
            } else {
                A.remove(i);
                A.add(i, num + 1);
                reminder = 0;
                break;
            }
        }
        if (reminder == 1) {
            A.add(0, 1);
        }
        return A;
    }
}
