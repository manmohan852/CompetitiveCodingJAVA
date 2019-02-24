package site.ibit.graph;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class LevelOrder {
   static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public static ArrayList<ArrayList<Integer>> solve(TreeNode tn){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if(tn == null) return res;

        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.add(tn);

        while(!dq.isEmpty()){
            int n =dq.size();
            ArrayList<Integer> arr = new ArrayList<>();
            for(int i=0;i<n;i++){
                tn = dq.poll();
                arr.add(tn.val);
                if(tn.left != null) dq.offer(tn.left);
                if(tn.right != null) dq.offer(tn.right);
            }
            res.add(arr);

        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(2);
        TreeNode p1 = new TreeNode(3);
        TreeNode p2 = new TreeNode(4);
        TreeNode p3 = new TreeNode(5);
        TreeNode p4 = new TreeNode(6);
        TreeNode p5 = new TreeNode(7);

        p.left = p1;
        p.right = p2;
        p1.left = p3;
        p3.left = p4;
        p4.left = p5;

        System.out.println(solve(p));


    }
}
