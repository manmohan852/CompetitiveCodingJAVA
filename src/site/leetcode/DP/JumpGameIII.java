package site.leetcode.DP;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/jump-game-iii/
public class JumpGameIII {

    //BFS
    //Time complexity: O(N)
    //Space complexity : O(N)
    public boolean canReach1(int[] arr, int start) {
        int n = arr.length;

        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int node = q.poll();
            // check if reach zero
            if (arr[node] == 0) {
                return true;
            }
            if (arr[node] < 0) {
                continue;
            }

            // check available next steps
            if (node + arr[node] < n) {
                q.offer(node + arr[node]);
            }
            if (node - arr[node] >= 0) {
                q.offer(node - arr[node]);
            }
            // mark as visited
            arr[node] = -arr[node];
        }
        return false;
    }

    //DFS
    //Time complexity: O(N), since we will visit every index only once.
    //Space complexity: O(N) since it needs at most O(N) stacks for recursions.
    public boolean canReach2(int[] arr, int start) {
        if (start >= 0 && start < arr.length && arr[start] >= 0) {
            if (arr[start] == 0) {
                return true;
            }
            arr[start] = -arr[start];
            return canReach2(arr, start + arr[start]) || canReach2(arr, start - arr[start]);
        }
        return false;
    }
}