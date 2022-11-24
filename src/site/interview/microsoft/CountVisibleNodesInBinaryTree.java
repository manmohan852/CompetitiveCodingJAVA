package site.interview.microsoft;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CountVisibleNodesInBinaryTree {

    //DFS
    // Time: O(n),O(n) time with dfs. As you traverse down the tree, pass the max number and see if the current node is bigger than that.
    // Space: O(n)
    public int countVisibleNodes(TreeNode root) {
        return countVisibleNodes(root, Integer.MIN_VALUE);
    }

    private int countVisibleNodes(TreeNode node, int maxSoFar) {
        if (node == null) return 0;

        int count = 0;

        if (node.val >= maxSoFar) {
            count = 1;
            maxSoFar = node.val;
        }

        return count + countVisibleNodes(node.left, maxSoFar) + countVisibleNodes(node.right, maxSoFar);
    }

    //BFS
    private static List<Integer> findVisibleNodeInTreeUtil(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeLevelNode> queue = new LinkedList<>();
        queue.offer(new TreeLevelNode(root, Integer.MIN_VALUE));
        while(!queue.isEmpty()){
            TreeLevelNode currLevelNode = queue.poll();
            if(currLevelNode.currNode.val >= currLevelNode.maxSoFar)
                result.add(currLevelNode.currNode.val);
            if(currLevelNode.currNode.left != null){
                queue.offer(new TreeLevelNode(currLevelNode.currNode.left, Math.max(currLevelNode.maxSoFar, currLevelNode.currNode.val)));
            }

            if(currLevelNode.currNode.right != null){
                queue.offer(new TreeLevelNode(currLevelNode.currNode.right, Math.max(currLevelNode.maxSoFar, currLevelNode.currNode.val)));
            }
        }
        return result;
    }

    static class TreeLevelNode{
        TreeNode currNode;
        int maxSoFar;
        TreeLevelNode(TreeNode currNode, int maxSoFar){
            this.currNode = currNode;
            this.maxSoFar = maxSoFar;
        }
    }

    static class TreeNode {
        int val;

        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }


    public static void main(String[] args) {
        // Create Tree
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(21);
        root.right.left = new TreeNode(1);

        System.out.println("Visible Nodes are : " + findVisibleNodeInTreeUtil(root));
    }
}
