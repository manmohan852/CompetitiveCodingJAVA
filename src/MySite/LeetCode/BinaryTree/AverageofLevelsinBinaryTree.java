package MySite.LeetCode.BinaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/average-of-levels-in-binary-tree/
public class AverageofLevelsinBinaryTree {
    public static void main(String[] args) {

    }
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new LinkedList<>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            double sum = 0.0;
            for(int i = 0; i < size; i++){
                TreeNode first = q.poll();
                sum += first.val;

                if(first.left != null){
                    q.add(first.left);
                }
                if(first.right != null){
                    q.add(first.right);
                }
            }
            res.add(sum / size);
        }
        return res;
    }
}
