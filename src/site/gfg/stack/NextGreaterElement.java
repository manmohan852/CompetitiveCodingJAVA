package site.gfg.stack;

import java.util.Stack;

//https://www.geeksforgeeks.org/next-greater-element/
public class NextGreaterElement {

    //Time Complexity: O(n).
    static void printNGE2(int arr[], int n) {
        int i = 0;
        Stack<Integer> s = new Stack<Integer>();
        int element, next;

        s.push(arr[0]);

        for (i = 1; i < n; i++) {
            next = arr[i];
            if (!s.isEmpty()) {
                element = s.pop();
                while (element < next) {
                    System.out.println(element + " --> " + next);
                    if (s.isEmpty())
                        break;
                    element = s.pop();
                }
                if (element > next)
                    s.push(element);
            }
            s.push(next);
        }
        while (s.isEmpty() == false) {
            element = s.pop();
            next = -1;
            System.out.println(element + " -- " + next);
        }
    }

    ////Time Complexity: O(n^2).
    static void printNGE1(int arr[], int n) {
        int next, i, j;
        for (i = 0; i < n; i++) {
            next = -1;
            for (j = i + 1; j < n; j++) {
                if (arr[i] < arr[j]) {
                    next = arr[j];
                    break;
                }
            }
            System.out.println(arr[i] + " -- " + next);
        }
    }


    public static void main(String[] args) {
        int arr[] = {11, 13, 21, 3};
        int n = arr.length;
        printNGE2(arr, n);
    }

}

