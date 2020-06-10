package site.leetcode.binaryTree;

import java.util.*;

//https://leetcode.com/problems/binary-tree-paths/
//257. Binary Tree Paths
public class BinaryTreePaths {
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

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Queue<List<TreeNode>> qu = new LinkedList<>();
        qu.add(Arrays.asList(root));
        while (!qu.isEmpty()) {
            List<TreeNode> path = qu.poll();
            TreeNode last = path.get(path.size() - 1);
            if (last.left == null && last.right == null) {
                String p = "";
                int len = 0;
                for (TreeNode node : path) {
                    len++;
                    if (len < path.size())
                        p += node.val + "->";
                    else
                        p += node.val;
                }
                ans.add(p);
            } else {
                List<TreeNode> left = new ArrayList<>(path);
                List<TreeNode> right = new ArrayList<>(path);
                if (last.left != null) {
                    left.add(last.left);
                    qu.add(left);
                }
                if (last.right != null) {
                    right.add(last.right);
                    qu.add(right);
                }
            }
        }
        return ans;
    }

    public List<String> binaryTreePathsRecursive(TreeNode root) {
        List<String> paths = new ArrayList<>();
        binaryRec(root, paths, "");
        return paths;
    }

    public void binaryRec(TreeNode root, List<String> paths, String path) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            path += root.val;
            paths.add(path);
            return;

        }
        binaryRec(root.left, paths, path + root.val + "->");
        binaryRec(root.right, paths, path + root.val + "->");
    }
}