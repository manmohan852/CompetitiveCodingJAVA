package MySite.LeetCode.BinaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
public class BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {

    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean leftToRight = true;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> sub = new LinkedList<>();
            for(int i = 0; i < size; i++){
                TreeNode first = q.poll();
                if(leftToRight){
                    sub.add(first.val);
                }else{
                    sub.add(0, first.val);
                }
                if(first.left != null){
                    q.add(first.left);
                }
                if(first.right != null){
                    q.add(first.right);
                }
            }
            leftToRight = !leftToRight;
            res.add(sub);
        }
        return res;
    }
}
