package site.leetcode.BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/sliding-puzzle/
//773. Sliding Puzzle
public class SlidingPuzzle {

    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        char[][] charBoard = new char[2][3];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                charBoard[i][j] = (char) (board[i][j] + '0');
            }
        }

        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<String>();
        if (toString(charBoard).equals(target)) return 0;
        q.add(toString(charBoard));
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int moves = 0;

        while (!q.isEmpty()) {
            moves++;
            int len = q.size();
            for (int idx = 0; idx < len; idx++) {
                String pop = q.poll();
                char[][] curr = toBoard(pop);
                int[] zeroIdx = findZeroIdx(pop);

                // make 4 way changes and push if not in visited
                for (int i = 0; i < dir.length; i++) {
                    int r = zeroIdx[0];
                    int c = zeroIdx[1];
                    int rNew = r + dir[i][0];
                    int cNew = c + dir[i][1];
                    if (rNew >= 0 && cNew >= 0 && rNew < 2 && cNew < 3) {
                        char temp = curr[r][c];
                        curr[r][c] = curr[rNew][cNew];
                        curr[rNew][cNew] = temp;
                        String currStr = toString(curr);
                        if (currStr.equals(target)) return moves;
                        if (!visited.contains(currStr)) {
                            q.add(currStr);
                            visited.add(currStr);
                        }
                        curr = toBoard(pop);
                    }
                }
            }
        }

        return -1;
    }

    private String toString(char[][] board) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                ans.append(board[i][j]);
            }
        }
        return ans.toString();
    }

    private char[][] toBoard(String s) {
        char[] split = s.toCharArray();
        char[][] ans = new char[2][3];
        ans[0][0] = split[0];
        ans[0][1] = split[1];
        ans[0][2] = split[2];
        ans[1][0] = split[3];
        ans[1][1] = split[4];
        ans[1][2] = split[5];

        return ans;
    }

    private int[] findZeroIdx(String s) {
        int pos1d = s.indexOf('0');
        return new int[]{
                pos1d / 3, pos1d % 3
        };
    }
}
