package MySite.LeetCode.BinaryTree;

import java.util.*;

// https://leetcode.com/problems/find-duplicate-subtrees/
public class FindDuplicateSubtrees {
    public static void main(String[] args) {

    }
    final String S = "X";
    Map<String, TreeNode> res = new HashMap<>();
    Set<String> visited = new HashSet<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        postOrderTraversal(root);
        return new LinkedList<>(res.values());
    }
    private String postOrderTraversal(TreeNode node){
        StringBuilder sb = new StringBuilder();
        String left = S, right = S;
        if(node.left != null){
            left = postOrderTraversal(node.left);
        }
        if(node.right != null){
            right = postOrderTraversal(node.right);
        }
        sb.append(node.val);
        sb.append(",");
        sb.append(left);
        sb.append(",");
        sb.append(right);
        String curSubtree = sb.toString();
        saveDuplicateSubtree(curSubtree, node);
        visited.add(curSubtree);
        return curSubtree;
    }
    private void saveDuplicateSubtree(String sb, TreeNode node){
        if(visited.contains(sb)){
            res.put(sb, node);
        }
    }
}
