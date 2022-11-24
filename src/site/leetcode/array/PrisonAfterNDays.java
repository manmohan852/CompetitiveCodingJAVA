package site.leetcode.array;

import java.util.HashMap;
//https://leetcode.com/problems/prison-cells-after-n-days/solution/
public class PrisonAfterNDays {

    static class Solution {

        protected int cellsToBitmap(int[] cells) {
            int stateBitmap = 0x0;
            for (int cell : cells) {
                stateBitmap <<= 1;
                stateBitmap = (stateBitmap | cell);
            }
            return stateBitmap;
        }

        protected int[] nextDay(int[] cells) {
            int[] newCells = new int[cells.length];
            newCells[0] = 0;
            for (int i = 1; i < cells.length - 1; i++)
                newCells[i] = (cells[i - 1] == cells[i + 1]) ? 1 : 0;
            newCells[cells.length - 1] = 0;
            return newCells;
        }

        public int[] prisonAfterNDays(int[] cells, int N) {

            HashMap<Integer, Integer> seen = new HashMap<>();
            boolean isFastForwarded = false;

            // step 1). run the simulation with hashmap
            while (N > 0) {
                if (!isFastForwarded) {
                    int stateBitmap = this.cellsToBitmap(cells);
                    if (seen.containsKey(stateBitmap)) {
                        // the length of the cycle is seen[state_key] - N
                        N %= seen.get(stateBitmap) - N;
                        isFastForwarded = true;
                    } else
                        seen.put(stateBitmap, N);
                }
                // check if there is still some steps remained,
                // with or without the fast-forwarding.
                if (N > 0) {
                    N -= 1;
                    cells = this.nextDay(cells);
                }
            }
            return cells;
        }
    }

    //Method 1
    public static int[] prisonAfterNDays(int[] cells, int N) {
        int m = cells.length;

        for (int i = 0; i < N; i++) {
            int nextState = 0;
            for (int j = 0; j < m; j++) {
                if (j == 0){
                    nextState = 0;
                }else if(j == m - 1) {
                    cells[j - 1] = nextState;
                    cells[j] = 0;
                } else if ((cells[j - 1] == 0 && cells[j + 1] == 0) || (cells[j - 1] == 1 && cells[j + 1] == 1)) {
                    cells[j - 1] = nextState;
                    nextState = 1;
                } else {
                    cells[j - 1] = nextState;
                    nextState = 0;
                }
            }
            printArray(cells);
        }
        return cells;
    }

    private static void printArray(int[] cells) {
        for (int i = 0;i< cells.length;i++){
            System.out.print(cells[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] cells = {0,1,0,1,1,0,0,1};// N=7, leetcode accepting the solution for method1
        //int[] cells = {1,0,0,1,0,0,1,0},// N = 1000000000, leetcode gives tle for method 1 for large value of N
        //printArray(cells);
        //prisonAfterNDays(cells, 7);


        int[] cell2 = {1,0,0,0,1,0,0,1}; // repeats after 15 steps
        Solution solution = new Solution();
        solution.prisonAfterNDays(cell2,18);
    }
}

