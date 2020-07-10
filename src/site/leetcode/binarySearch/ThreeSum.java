package site.leetcode.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
//https://www.interviewbit.com/problems/3-sum-zero/
//https://leetcode.com/problems/3sum/
public class ThreeSum {

    public static List<List<Integer>> threeSum2(int[] A) {
        Arrays.sort(A);
        List<List<Integer>> output = new ArrayList<>();
        for (int i = 0; i < (A.length - 2) && A[i] <= 0; i++) {
            if (i > 0 && (A[i] == A[i - 1])) {
                continue;
            }
            int j = i + 1;
            int k = A.length - 1;
            while (j < A.length && k > j) {
                if ((long) A[i] + (long) A[j] + (long) A[k] == 0) {
                    List<Integer> last = null;
                    if (output.size() > 0) {
                        last = output.get(output.size() - 1);
                    }
                    if (last == null
                            || !last.get(0).equals(A[i])
                            || !last.get(1).equals(A[j])
                            || !last.get(2).equals(A[k])) {
                        ArrayList<Integer> zeroSum = new ArrayList<Integer>();
                        zeroSum.add(A[i]);
                        zeroSum.add(A[j]);
                        zeroSum.add(A[k]);
                        output.add(zeroSum);
                    }
                    j++;
                    k--;
                } else if ((long) A[i] + (long) A[j] + (long) A[k] < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return output;
    }

    public static ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        for (int i = 0; i < (A.size() - 2) && A.get(i) <= 0; i++) {
            if (i > 0 && (A.get(i).equals(A.get(i - 1)))) {
                continue;
            }
            int j = i + 1;
            int k = A.size() - 1;
            while (j < A.size() && k > j) {
                if ((long) A.get(i) + (long) A.get(j) + (long) A.get(k) == 0) {
                    ArrayList<Integer> last = null;
                    if (output.size() > 0) {
                        last = output.get(output.size() - 1);
                    }
                    if (last == null
                            || !last.get(0).equals(A.get(i))
                            || !last.get(1).equals(A.get(j))
                            || !last.get(2).equals(A.get(k))) {
                        ArrayList<Integer> zeroSum = new ArrayList<Integer>();
                        zeroSum.add(A.get(i));
                        zeroSum.add(A.get(j));
                        zeroSum.add(A.get(k));
                        output.add(zeroSum);
                    }
                    j++;
                    k--;
                } else if ((long) A.get(i) + (long) A.get(j) + (long) A.get(k) < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return output;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr  = new ArrayList<>(Arrays.asList(-1, 0, 1, 2, -1, -4));
        int[] nums = {-1, 0, 1, 2, -1, -4};
        //threeSum(arr);
        threeSum2(nums);
    }
}
