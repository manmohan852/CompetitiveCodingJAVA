package site.interview.amazon;

import java.util.*;
//TimeComplexity = O(n)
public class CommonAncestorOfNaryTree {

    static class TreeNode {
        int val;
        List<TreeNode> childs;
        TreeNode parent;

        TreeNode(int val) {
            this.val = val;
            this.parent = null;
        }

        void addNodes(List<TreeNode> nodes) {
            if (this.childs == null) {
                this.childs = new ArrayList<>();
            }
            this.childs.addAll(nodes);
            for (TreeNode node : nodes) {
                node.parent = this;
            }
        }
    }

    static TreeNode findNode(TreeNode root,int value){
        if(root == null){
            return null;
        }
        if(root.val == value){
            return root;
        }else if(root.childs != null){
            for (TreeNode treeNode : root.childs){
                TreeNode answerNode = findNode(treeNode,value);
                if(answerNode != null){
                    return answerNode;
                }
            }
        }
        return null;
    }

    static TreeNode LCA(TreeNode root, int a, int b) {
        if (getLevel(root, a) > getLevel(root, b)) {
            int temp = a;
            a = b;
            b = temp;
        }
        TreeNode A = findNode(root,a);
        TreeNode B = findNode(root,b);
        int d = getLevel(root, b) - getLevel(root, a);
        while (d > 0) {
            B = B.parent;
            d--;
        }
        if (a == b)
            return A;
        while (A.parent != B.parent) {
            A = A.parent;
            B = B.parent;
        }
        return A.parent;
    }

    static int getLevel(TreeNode root, int value) {
        Queue<TreeNode> q = new LinkedList<>();
        int level = 1;
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            TreeNode temp = q.poll();
            if (temp == null) {
                if (q.peek() != null) {
                    q.add(null);
                }
                level += 1;
            } else {
                if (temp.val == value) {
                    return level;
                }
                if (!temp.childs.isEmpty()) {
                    for (TreeNode child : temp.childs) {
                        q.add(child);
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);
        root.addNodes(Arrays.asList(node1, node2, node3));
        node2.addNodes(Arrays.asList(node4, node5));
        node3.addNodes(Arrays.asList(node6));



    }
}
