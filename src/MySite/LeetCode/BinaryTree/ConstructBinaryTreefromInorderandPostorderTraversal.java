package MySite.LeetCode.BinaryTree;

import java.util.HashMap;

// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
public class ConstructBinaryTreefromInorderandPostorderTraversal {
    public static void main(String[] args) {

    }
    int index;
    int[] inOrder;
    int[] postOrder;
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inOrder = inorder;
        postOrder = postorder;
        int n = inOrder.length;
        index = n - 1;
        for(int i = 0; i < n; i++){
            map.put(inOrder[i], i);
        }
        TreeNode root = dfs(0, n - 1);
        return root;
    }
    private TreeNode dfs(int start, int end){
        if(start > end) return null;
        int curVal = postOrder[index--];
        TreeNode cur = new TreeNode(curVal);
        int mid = map.get(curVal);
        cur.right = dfs(mid + 1, end);
        cur.left = dfs(start, mid - 1);
        return cur;
    }
}
