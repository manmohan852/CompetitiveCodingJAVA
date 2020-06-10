package site.leetcode.binaryTree;
//https://leetcode.com/problems/invert-binary-tree/
//226. Invert Binary Tree

import java.util.LinkedList;
import java.util.Queue;

class InvertBinaryTree {

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

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode head = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp;
            root = queue.poll();
            temp = root.right;
            root.right = root.left;
            root.left = temp;
            if (root.left != null) {
                queue.add(root.left);
            }
            if (root.right != null) {
                queue.add(root.right);
            }
        }
        return head;
    }

    public TreeNode invertTreeRecursive(TreeNode root) {
        if(root==null)
            return null;
        root = invert(root);
        return root;
    }
    public TreeNode invert(TreeNode root)
    {
        if(root.left== null && root.right == null)
            return root;
        if(root.left!=null)
            invert(root.left);
        if(root.right!=null)
            invert(root.right);
        TreeNode temp= root.left;
        root.left = root.right;
        root.right = temp;

        return root;
    }


}
