package MySite.LeetCode.BinaryTree;
// https://leetcode.com/problems/symmetric-tree/
public class SymmetricTree {
    public static void main(String[] args) {

    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetric(root.left, root.right);
    }
    private boolean isSymmetric(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left != null && right != null){
            return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
        }
        return false;
    }
}
