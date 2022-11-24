package site.leetcode.binaryTree;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/flip-equivalent-binary-trees/
public class FlipEquivalentBinaryTrees {

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

    //Time Complexity: O(min(N_1, N_2)), where N_1, N_2N are the lengths of root1 and root2.
    //Space Complexity: O(min(H_1, H_2)), where H_1, H_2H are the heights of the trees of root1 and root2.
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == root2)
            return true;
        if (root1 == null || root2 == null || root1.val != root2.val)
            return false;
        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right) ||
                flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
    }

    //Time Complexity: O(N_1 + N_2), where N_1, N_2N are the lengths of root1 and root2.
    //Space Complexity: O(N_1 + N_2), where N_1, N_2N are the lengths of root1 and root2.
    public boolean flipEquiv2(TreeNode root1, TreeNode root2) {
        List<Integer> vals1 = new ArrayList<>();
        List<Integer> vals2 = new ArrayList();
        dfs(root1, vals1);
        dfs(root2, vals2);
        return vals1.equals(vals2);
    }

    public void dfs(TreeNode node, List<Integer> vals) {
        if (node != null) {
            vals.add(node.val);
            int L = node.left != null ? node.left.val : -1;
            int R = node.right != null ? node.right.val : -1;
            if (L < R) {
                dfs(node.left, vals);
                dfs(node.right, vals);
            } else {
                dfs(node.right, vals);
                dfs(node.left, vals);
            }
            vals.add(null);
        }
    }

}
