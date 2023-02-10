package MySite.LeetCode.BinaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {

    }
    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if(root == null) return res;
        Stack<TreeNode> st = new Stack<>();
        TreeNode curroot = root;
        while(true){
            while(curroot != null){
                st.add(curroot);
                curroot = curroot.left;
            }
            if(st.isEmpty() == true) break;
            curroot = st.pop();
            res.add(curroot.val);
            curroot = curroot.right;
        }
        return res;
    }
}
