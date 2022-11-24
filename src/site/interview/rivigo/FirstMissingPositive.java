package site.interview.rivigo;

import java.util.ArrayList;
import java.util.Arrays;

//https://www.interviewbit.com/problems/first-missing-integer/
//https://leetcode.com/problems/first-missing-positive/solution/
public class FirstMissingPositive {

    public static int firstMissingPositive(ArrayList<Integer> A) {
        for (int i = 0; i < A.size(); i++) {
            int num = A.get(i);
            int pos = num - 1;

            if (pos >= 0 && pos < A.size() && A.get(pos) != num) {
                A.set(i, A.get(pos));
                A.set(pos, num);
                i--;
            }
        }

        for (int i = 0; i < A.size(); i++)
            if (A.get(i) != i + 1)
                return i + 1;

        return A.size() + 1;
    }

    public int firstMissingPositive(int[] A) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            if (A[i] > 0 && A[i] <= n) {
                if (A[i] - 1 != i && A[A[i] - 1] != A[i]) {
                    int temp = A[A[i] - 1];
                    A[A[i] - 1] = A[i];
                    A[i] = temp;
                    i--;
                }
            }
        }
        for (int i = 0; i < n; i++)
            if (A[i] != i + 1)
                return i + 1;
        return n + 1;
    }

    public int firstMissingPositive3(int[] nums) {
        int n = nums.length;
        int contains = 0;
        for (int i = 0; i < n; i++)
            if (nums[i] == 1) {
                contains++;
                break;
            }
        if (contains == 0)
            return 1;
        if (n == 1)
            return 2;
        // Replace negative numbers, zeros,
        // and numbers larger than n by 1s.
        // After this convertion nums will contain
        // only positive numbers.
        for (int i = 0; i < n; i++)
            if ((nums[i] <= 0) || (nums[i] > n))
                nums[i] = 1;

        // Use index as a hash key and number sign as a presence detector.
        // For example, if nums[1] is negative that means that number `1`
        // is present in the array.
        // If nums[2] is positive - number 2 is missing.
        for (int i = 0; i < n; i++) {
            int a = Math.abs(nums[i]);
            // If you meet number a in the array - change the sign of a-th element.
            // Be careful with duplicates : do it only once.
            if (a == n)
                nums[0] = -Math.abs(nums[0]);
            else
                nums[a] = -Math.abs(nums[a]);
        }
        // Now the index of the first positive number
        // is equal to first missing positive.
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0)
                return i;
        }
        if (nums[0] > 0)
            return n;
        return n + 1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, 0));
        ArrayList<Integer> D = new ArrayList<>(Arrays.asList(4, 2,3,4,7, 0));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(3, 4, -1, 1));
        ArrayList<Integer> C = new ArrayList<>(Arrays.asList(-8, -7, -6));
        firstMissingPositive(D);
    }


}
