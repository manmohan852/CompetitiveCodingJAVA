package site.leetcode.binaryTree;

import java.util.Deque;
import java.util.LinkedList;

public class CousinsInBinaryTree {
    class Pair {
        TreeNode parent;
        int level;

        Pair(TreeNode parent, int level) {
            this.parent = parent;
            this.level = level;
        }
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        Pair pair1 = isCousinsHelper(root, x, null, 0);
        Pair pair2 = isCousinsHelper(root, y, null, 0);

        return pair1.level == pair2.level && pair1.parent != pair2.parent;
    }

    Pair isCousinsHelper(TreeNode root, int val, TreeNode parent, int level) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return new Pair(parent, level);
        }
        Pair leftPair = isCousinsHelper(root.left, val, root, level + 1);
        Pair rightPair = isCousinsHelper(root.right, val, root, level + 1);
        return leftPair == null ? rightPair : leftPair;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isCousinsBFS(TreeNode root, int x, int y) {
        //If any of x or y is at root, it means they can't be at same depth. Return false.
        if (root.val == x || root.val == y) return false;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean xFound = false;
        boolean yFound = false;
        int parentX = 0;
        int parentY = 0;
        //Do level-order traversal until x or y is found or queue is empty.
        while (!queue.isEmpty() && !xFound && !yFound) {
            int size = queue.size();
            //Traverse that level.
            while (size-- > 0) {
                TreeNode node = queue.poll();
                //if x or y is found at left/right, save the parent and set the "found" flag to true.
                //This flag will break the loop as soon as any one (x or y) is found.
                //we don't need to go deeper to find second if it isn't found at this level.
                if (node.left != null) {
                    queue.offer(node.left);
                    if (node.left.val == x) {
                        parentX = node.val;
                        xFound = true;
                    }
                    if (node.left.val == y) {
                        parentY = node.val;
                        yFound = true;
                    }
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    if (node.right.val == x) {
                        parentX = node.val;
                        xFound = true;
                    }
                    if (node.right.val == y) {
                        parentY = node.val;
                        yFound = true;
                    }
                }
            }
        }
        return xFound && yFound && parentX != parentY;
    }
}
