package site.ibit.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
//https://www.interviewbit.com/problems/largest-number/
public class LargestNumber {
    public static String largestNumber(final List<Integer> a) {
        String[] arr = new String[a.size()];
        for (int i = 0; i < a.size(); i++) {
            arr[i] = String.valueOf(a.get(i));
        }
        Arrays.sort(arr, new Comparator<String>() {
            public int compare(String a, String b) {
                //9,5 -> 59, 95; a comes first when b+a is less than or eq to a+b
                return (b + a).compareTo(a + b);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }
        if (sb.charAt(0) == '0') {//when all elements are zeros,//check if all zeroes are there,return a single zero
            return String.valueOf(0);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(3);
        a.add(30);
        a.add(34);
        a.add(5);
        a.add(9);
        a.add(07);// 7 get added , not 07 here.
        String out = largestNumber(a);
    }
}
