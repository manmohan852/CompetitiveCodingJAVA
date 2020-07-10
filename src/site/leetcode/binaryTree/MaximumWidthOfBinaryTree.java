package site.leetcode.binaryTree;

import java.util.*;
//https://leetcode.com/articles/maximum-width-of-binary-tree/
public class MaximumWidthOfBinaryTree {

    private static Integer maxWidth = 0;
    private static HashMap<Integer, Integer> firstColIndexTable;

    //BFS
    //Time Complexity: O(N)
    //Space Complexity: O(N)
    public static int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        LinkedList<Pair> queue = new LinkedList<>();
        Integer maxWidth = 0;
        queue.addLast(new Pair(root, 0));
        while (queue.size() > 0) {
            Pair head = queue.getFirst();
            Integer currLevelSize = queue.size();
            Pair elem = null;
            for (int i = 0; i < currLevelSize; ++i) {
                elem = queue.removeFirst();
                TreeNode node = elem.node;
                if (node.left != null)
                    queue.addLast(new Pair(node.left, 2 * elem.value));
                if (node.right != null)
                    queue.addLast(new Pair(node.right, 2 * elem.value + 1));
            }
            maxWidth = Math.max(maxWidth, elem.value - head.value + 1);
        }
        return maxWidth;
    }

    //DFS
    //Time Complexity: O(N)
    //Space Complexity: O(N)
    public static int widthOfBinaryTree2(TreeNode root) {
        // table contains the first col_index for each level
        firstColIndexTable = new HashMap<Integer, Integer>();
        // start from depth = 0, and colIndex = 0
        DFS(root, 0, 0);
        return maxWidth;
    }

    public static class Pair {
        TreeNode node;
        Integer value;

        Pair(TreeNode node, Integer value) {
            this.node = node;
            this.value = value;
        }
    }

    protected static void DFS(TreeNode node, Integer depth, Integer colIndex) {
        if (node == null)
            return;
        // initialize the value, for the first seen colIndex per level
        if (!firstColIndexTable.containsKey(depth)) {
            firstColIndexTable.put(depth, colIndex);
        }
        Integer firstColIndex = firstColIndexTable.get(depth);
        maxWidth = Math.max(maxWidth, colIndex - firstColIndex + 1);
        // Preorder DFS. Note: it is important to put the priority on the left child
        DFS(node.left, depth + 1, 2 * colIndex);
        DFS(node.right, depth + 1, 2 * colIndex + 1);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        //TestCase1
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.right.right = new TreeNode(9);
        root.left.left.left = new TreeNode(6);
        root.right.right.right = new TreeNode(7);

        //TestCase2
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(3);
        root2.left.left = new TreeNode(5);
        root2.left.right = new TreeNode(3);

        //TestCase3
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(3);
        root3.left.left = new TreeNode(5);
        root3.left.right = new TreeNode(3);
        widthOfBinaryTree(root);


    }
}
