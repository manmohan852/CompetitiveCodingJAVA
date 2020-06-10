package site.leetcode.binaryTree;

import site.leetcode.bst.RecoverBinarySearchTree;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/maximum-depth-of-binary-tree/
public class MaximumDepthOfBinaryTree {

    //depth of root node is 1;

    public int maxDepthDFS(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left_height = maxDepthDFS(root.left);
            int right_height = maxDepthDFS(root.right);
            return java.lang.Math.max(left_height, right_height) + 1;
        }
    }

    public int maxDepthBFS(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> dq = new ArrayDeque<>();
        int depth = 0, next = 0;
        TreeNode cur;
        dq.offer(root);

        while (!dq.isEmpty()) {
            depth++;
            next = dq.size();
            for (int i = 0; i < next; ++i) {
                cur = dq.poll();
                if (cur.left != null) dq.offer(cur.left);
                if (cur.right != null) dq.offer(cur.right);
            }
        }
        return depth;
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
