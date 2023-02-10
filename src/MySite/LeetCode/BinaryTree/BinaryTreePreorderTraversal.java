package MySite.LeetCode.BinaryTree;


import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/binary-tree-preorder-traversal/
public class BinaryTreePreorderTraversal {
    public static void main(String[] args) {

    }
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if(root == null) return res;
        Stack<TreeNode> st = new Stack<>();
        st.add(root);
        while(!st.isEmpty()){
            TreeNode top = st.pop();
            res.add(top.val);
            if(top.right != null){
                st.add(top.right);
            }
            if(top.left != null){
                st.add(top.left);
            }
        }
        return res;
    }
}
