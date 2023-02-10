package MySite.LeetCode.BinaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {

    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> sub = new LinkedList<>();
            for(int i = 0; i < size; i++){
                TreeNode first = q.poll();
                sub.add(first.val);
                if(first.left != null){
                    q.add(first.left);
                }
                if(first.right != null){
                    q.add(first.right);
                }
            }
            res.add(sub);
        }
        return res;
    }
}
