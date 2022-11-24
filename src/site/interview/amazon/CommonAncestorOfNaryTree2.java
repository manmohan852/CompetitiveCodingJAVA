package site.interview.amazon;

import java.util.*;

//TimeComplexity = O(logn)
//bug present//refer CommonAncestorOfNaryTree3.java , thats correct
public class CommonAncestorOfNaryTree2 {

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

    static TreeNode findNode(TreeNode root, int value) {
        if (root == null) {
            return null;
        }
        if (root.val == value) {
            return root;
        } else if (root.childs != null) {
            for (TreeNode treeNode : root.childs) {
                TreeNode answerNode = findNode(treeNode, value);
                if (answerNode != null) {
                    return answerNode;
                }
            }
        }
        return null;
    }

    static void dfs(TreeNode root, int[][] distance, int[] level, int source, int parent, int lvl) {
        distance[source][0] = parent;
        level[source] = lvl;
        for (int i = 0; i <= 18; i++) {
            if (distance[source][i] != -1) {
                distance[source][i + 1] = distance[distance[source][i]][i];
            }
        }
        if (root.childs != null) {
            for (TreeNode child : root.childs) {
                if (child.val != parent) {
                    dfs(child, distance, level, child.val, root.val, lvl + 1);
                }
            }
        }
    }

    static TreeNode findLCA(TreeNode root, int[][] distance, int[] level, int a, int b) {
        if (level[a] > level[b]) {
            int temp = a;
            a = b;
            b = temp;
        }
        int difference = level[b] - level[b];
        for (int i = 19; i >= 0; i--) {
            if (((difference >> i) & 1) == 1) { //checking the ith bit is set
                b = distance[b][i];
            }
        }
        // base case when one node was ancestor of other
        if (a == b) {
            return findNode(root, a);
        }
        for (int i = 19; i >= 0; i--) {
            if (distance[a][i] != distance[b][i]) {
                a = distance[a][i];
                b = distance[b][i];
            }
        }
        return findNode(root, distance[a][0]);
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
//        int N = 10 ^ 6;
        int N = 1000000;
        //log2(N) is taken as 20
        int[][] distance = new int[N][(int) (Math.log(N) / Math.log(2))];
        for (int i = 0; i < 100000; i++) {
            Arrays.fill(distance[i], -1);
        }
        int[] level = new int[N];
        dfs(root, distance, level, root.val, 0, 1);
        findLCA(root, distance, level, 4, 5);
    }
}



// This code is contributed by 29AjayKumar

