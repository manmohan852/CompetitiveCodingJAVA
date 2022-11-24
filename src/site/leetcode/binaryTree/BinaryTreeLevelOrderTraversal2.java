package site.leetcode.binaryTree;

import java.util.*;

public class BinaryTreeLevelOrderTraversal2 {
    public static class TreeNode {
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

    public static List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);

        while(!queue.isEmpty()){
            int n = queue.size();
            List<Integer> ans = new ArrayList<>();
            for(int i = 0;i<n;i++){
                TreeNode current = queue.poll();
                ans.add(current.val);
                if(current.left != null){
                    queue.add(current.left);
                }
                if(current.right != null){
                    queue.add(current.right);
                }
            }
            result.add(ans);
        }
        Collections.reverse(result);
        return result;
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int n = queue.size();
            List<Integer> ans = new ArrayList<>();
            for(int i = 0;i<n;i++){
                TreeNode current = queue.poll();
                ans.add(current.val);
                if(current.left != null){
                    queue.add(current.left);
                }
                if(current.right != null){
                    queue.add(current.right);
                }
            }
            result.add(ans);
        }
        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        levelOrderBottom(root);

    }
}
