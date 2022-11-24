package site.gfg.stack;

import java.util.Stack;

//https://www.geeksforgeeks.org/the-celebrity-problem/
//Time Complexity: O(n).
public class TheCelebrityProblemUsingStack {
    static int MATRIX[][] = {{0, 0, 1, 0},
            {0, 0, 1, 0},
            {0, 0, 0, 0},
            {0, 0, 1, 0}};

    static boolean knows(int a, int b) {
        boolean res = (MATRIX[a][b] == 1) ?
                true :
                false;
        return res;
    }

    static int findCelebrity(int n) {
        Stack<Integer> st = new Stack<>();
        int c;
        for (int i = 0; i < n; i++) {
            st.push(i);
        }
        while (st.size() > 1) {
            int a = st.pop();
            int b = st.pop();
            if (knows(a, b)) {
                st.push(b);
            } else
                st.push(a);
        }
        c = st.pop();
        for (int i = 0; i < n; i++) {
            if (i != c && (knows(c, i) ||
                    !knows(i, c)))
                return -1;
        }
        return c;
    }

//    Time Complexity: O(n).
    static int findCelebrityUsinggTwoPointers(int n) {
        int a = 0;
        int b = n - 1;
        while (a < b) {
            if (knows(a, b))
                a++;
            else
                b--;
        }
        for (int i = 0; i < n; i++) {
            if (i != a && (knows(a, i) ||
                    !knows(i, a)))
                return -1;
        }
        return a;
    }

    //Time Complexity: O(n^2).
    int findCelebrityUsingGraph(int n) {
        int[] indegree = new int[n];
        int[] outdegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x = 0;
                if (knows(i, j)) {
                    x = 1;
                }
                outdegree[i] += x;
                indegree[j] += x;
            }
        }
        for (int i = 0; i < n; i++)
            if (indegree[i] == n - 1 && outdegree[i] == 0)
                return i;
        return -1;
    }

    public static void main(String[] args) {
        int n = 4;
        int result = findCelebrity(n);
        if (result == -1) {
            System.out.println("No Celebrity");
        } else
            System.out.println("Celebrity ID " +
                    result);
    }
}
