package site.leetcode.BFS;

import java.util.*;

//https://leetcode.com/problems/jump-game-iv/
public class JumpGame4 {

    public int minJumps(int[] arr) {
        int n = arr.length;
        // initialize valuesToIndices
        HashMap<Integer, Set<Integer>> valuesToIndices
                = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int v = arr[i];
            if (!valuesToIndices.containsKey(v)) {
                valuesToIndices.put(v, new HashSet<>());
            }
            valuesToIndices.get(v).add(i);
        }
        // BFS
        HashSet<Integer> found = new HashSet<>();
        HashSet<Integer> valuesVisited = new HashSet<>();
        found.add(0);
        int current = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        Queue<Integer> nextQ = new LinkedList<>();
        while (!q.isEmpty() || !nextQ.isEmpty()) {
            if (q.isEmpty()) {
                q = nextQ;
                nextQ = new LinkedList<>();
                current++;
            } else {
                int i = q.remove();
                if (i == n - 1) {
                    // arrived at the last index
                    return current;
                }
                if (i > 0 && !found.contains(i - 1)) {
                    found.add(i - 1);
                    nextQ.add(i - 1);

                }
                if (!found.contains(i + 1)) {
                    found.add(i + 1);
                    nextQ.add(i + 1);
                }
                int v = arr[i];
                if (!valuesVisited.contains(v)) {
                    valuesVisited.add(v);
                    for (int x : valuesToIndices.get(v)) {
                        if (!found.contains(x)) {
                            found.add(x);
                            nextQ.add(x);
                        }
                    }
                }
            }
        }
        return -1;
    }
}
