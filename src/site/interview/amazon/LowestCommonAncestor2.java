package site.interview.amazon;
//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
public class LowestCommonAncestor2 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static TreeNode ans;

    private static boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {
        if (currentNode == null) {
            return false;
        }
        int left = recurseTree(currentNode.left, p, q) ? 1 : 0;
        int right = recurseTree(currentNode.right, p, q) ? 1 : 0;
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;
        if (mid + left + right >= 2) {
            ans = currentNode;
        }
        return (mid + left + right > 0);
    }

    //Time Complexity: O(N), where N is the number of nodes in the binary tree
    //Space Complexity: O(N). This is because the maximum amount of space utilized
    // by the recursion stack would be N
    // since the height of a skewed binary tree could be N.
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recurseTree(root, p, q);
        return ans;
    }

    public static void main(String[] args) {
        ans = null;
    }
}