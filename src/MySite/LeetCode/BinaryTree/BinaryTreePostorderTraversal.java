package MySite.LeetCode.BinaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/binary-tree-postorder-traversal/
public class BinaryTreePostorderTraversal {
    public static void main(String[] args) {

    }
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if(root == null) return res;
        Stack<TreeNode> st = new Stack<>();
        st.add(root);
        while(!st.isEmpty()){
            TreeNode top = st.pop();
            res.add(0, top.val);
            if(top.left != null){
                st.add(top.left);
            }
            if(top.right != null){
                st.add(top.right);
            }
        }
        return res;
    }
}
