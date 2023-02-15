package MySite.LeetCode.BinaryTree;

import java.util.HashMap;

// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public static void main(String[] args) {

    }
    int index = 0;
    int[] inOrder;
    int[] preOrder;
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inOrder = inorder;
        preOrder = preorder;
        int n = inOrder.length;
        for(int i = 0; i < n; i++){
            map.put(inOrder[i], i);
        }
        TreeNode root = dfs(0, n - 1);
        return root;
    }
    private TreeNode dfs(int start, int end){
        if(start > end) return null;
        int curVal = preOrder[index++];
        TreeNode cur = new TreeNode(curVal);
        int mid = map.get(curVal);
        cur.left = dfs(start, mid - 1);
        cur.right = dfs(mid + 1, end);
        return cur;
    }
}
