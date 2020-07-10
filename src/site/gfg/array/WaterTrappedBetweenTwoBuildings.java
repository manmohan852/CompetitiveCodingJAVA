package site.gfg.array;

import java.util.Arrays;

//https://www.geeksforgeeks.org/maximum-water-that-can-be-stored-between-two-buildings/?ref=rp
//Assuming to delete N-2 buildings such that the water that can be trapped between the remaining two building is maximum
public class WaterTrappedBetweenTwoBuildings {

    //Time Complexity: O(N)
    static int maxWater1(int height[], int n) {
        int max = 0;
        int i = 0, j = n - 1;
        while (i < j) {
            if (height[i] < height[j]) {
                max = Math.max(max, (j - i - 1) * height[i]);
                i++;
            }
            else if (height[j] < height[i]) {
                max = Math.max(max, (j - i - 1) * height[j]);
                j--;
            }
            else {
                max = Math.max(max, (j - i - 1) * height[i]);
                i++;
                j--;
            }
        }
        return max;
    }

    //Time Complexity : O(N*log(N)).
    static int maxWater2(int height[], int n) {

        // Make pairs with indices
        Pair pairs[] = new Pair[n];
        for (int i = 0; i < n; i++)
            pairs[i] = new Pair(i, height[i]);

        // Sort array based on heights
        Arrays.sort(pairs);

        // To store the min and max index so far
        // from the right
        int minIndSoFar = pairs[n - 1].ind;
        int maxIndSoFar = pairs[n - 1].ind;
        int max = 0;
        for (int i = n - 2; i >= 0; i--) {

            // Current building paired with the building
            // greater in height and on the extreme left
            int left = 0;
            if (minIndSoFar < pairs[i].ind) {
                left = (pairs[i].val * (pairs[i].ind - minIndSoFar - 1));
            }

            // Current building paired with the building
            // greater in height and on the extreme right
            int right = 0;
            if (maxIndSoFar > pairs[i].ind) {
                right = (pairs[i].val * (maxIndSoFar - pairs[i].ind - 1));
            }

            // Maximum so far
            max = Math.max(left, Math.max(right, max));

            // Update the maximum and minimum so far
            minIndSoFar = Math.min(minIndSoFar,
                    pairs[i].ind);
            maxIndSoFar = Math.max(maxIndSoFar,
                    pairs[i].ind);
        }

        return max;
    }

    //minimum(h1, h2)*(distance between the buildings-1)
    //Time Complexity : O(N*N).
    static int maxWater3(int height[], int n) {
        int max = 0;

        // Check all possible pairs of buildings
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int current = (Math.min(height[i],
                        height[j])
                        * (j - i - 1));

                // Maximum so far
                max = Math.max(max, current);
            }
        }
        return max;
    }

    // Driver code
    public static void main(String[] args) {
        int height[] = {2, 1, 3, 4, 6, 5};
        int n = height.length;

        System.out.print(maxWater1(height, n));
    }
}

// Class to store the pairs
class Pair implements Comparable<Pair> {
    int ind, val;

    Pair(int ind, int val) {
        this.ind = ind;
        this.val = val;
    }

    @Override
    public int compareTo(Pair o) {
        if (this.val > o.val)
            return 1;
        return -1;
    }
}



