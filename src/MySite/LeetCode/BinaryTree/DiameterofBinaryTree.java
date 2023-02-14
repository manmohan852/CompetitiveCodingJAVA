package MySite.LeetCode.BinaryTree;
// https://leetcode.com/problems/diameter-of-binary-tree/description/
public class DiameterofBinaryTree {
    public static void main(String[] args) {

    }
    int max  = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return max;
    }
    private int dfs(TreeNode node){
        int left = 0, right = 0;
        if(node.left != null){
            left = dfs(node.left);
        }
        if(node.right != null){
            right = dfs(node.right);
        }
        max = Math.max(max, right + left);
        return Math.max(left, right) + 1;
    }//
}
