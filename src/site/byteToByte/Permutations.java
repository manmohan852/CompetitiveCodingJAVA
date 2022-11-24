package site.byteToByte;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        System.out.println(listPermutations2(a));
        System.out.println();
    }

    public static List<String> stringPermutations(String s) {
        List<String> result = new ArrayList<String>();
        stringPermutations("", s, result);
        return result;
    }

    private static void stringPermutations(String prefix, String suffix, List<String> results) {
        if (suffix.length() == 0) {
            results.add(prefix);
        } else {
            for (int i = 0; i < suffix.length(); i++) {
                stringPermutations(prefix + suffix.charAt(i), suffix.substring(0, i) + suffix.substring(i + 1, suffix.length()), results);
            }
        }
    }


    public static List<int[]> listPermutations(int[] a) {
        ArrayList<int[]> results = new ArrayList<int[]>();
        listPermutations(a, 0, results);
        return results;
    }

    public static List<List<Integer>> listPermutations2(int[] b) {
        List<List<Integer>> results = new ArrayList<>();
        Integer[] a = Arrays.stream(b).boxed().toArray(Integer[]::new);
        listPermutations2(a, 0, results);
        return results;
    }

    private static void listPermutations2(Integer[] a, int start, List<List<Integer>> result) {
        if (start >= a.length) {
            List<Integer> clone = new ArrayList<>();
            clone.addAll(Arrays.asList(a));
            result.add(clone);
        } else {
            for (int i = start; i < a.length; i++) {
                swap2(a, start, i);
                listPermutations2(a, start + 1, result);
                swap2(a, start, i);
            }
        }
    }

    private static void listPermutations(int[] a, int start, List<int[]> result) {
        if (start >= a.length) {
            result.add(a.clone());
        } else {
            for (int i = start; i < a.length; i++) {
                swap(a, start, i);
                listPermutations(a, start + 1, result);
                swap(a, start, i);
            }
        }
    }

    private static void swap2(Integer[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
