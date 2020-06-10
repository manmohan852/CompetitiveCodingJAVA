package site.leetcode.bst;

import site.leetcode.DFS.PathSum;

public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBSTRecursive(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBSTRecursive(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return isValidBSTRecursive(root.left, min, root.val) && isValidBSTRecursive(root.right, root.val, max);
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
}