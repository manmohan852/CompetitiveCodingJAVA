package site.leetcode.binaryTree;

//https://leetcode.com/articles/same-tree/
public class SameTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //Time complexity : O(N), where N is a number of nodes in the tree, since one visits each node exactly once.
    //Space complexity : O(log(N)) in the best case of completely balanced tree and O(N) in the worst case of completely unbalanced tree,
    // to keep a recursion stack.
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // p and q are both null
        if (p == null && q == null) return true;
        // one of p and q is null
        if (q == null || p == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.right, q.right) &&
                isSameTree(p.left, q.left);
    }






}
