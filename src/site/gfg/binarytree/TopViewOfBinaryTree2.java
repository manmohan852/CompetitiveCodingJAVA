package site.gfg.binarytree;

import java.util.*;
//Time Complexity : O(n), using hashmap would cost O(1)
//Space Complexity : O(n)
public class TopViewOfBinaryTree2 {
    Node root;

    public TopViewOfBinaryTree2() {
        root = null;
    }

    private void topview(Node root) {
        class QueueObj {
            Node node;
            int hd;

            QueueObj(Node node, int hd) {
                this.node = node;
                this.hd = hd;
            }
        }
        Queue<QueueObj> q = new LinkedList<>();
        Map<Integer, Node> hashMap = new HashMap<>();

        if (root == null) {
            return;
        } else {
            q.add(new QueueObj(root, 0));
        }

        System.out.println("The top view of the tree is : ");

        int minLevel = Integer.MAX_VALUE;
        int maxLevel = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            QueueObj tmpNode = q.poll();
            if (!hashMap.containsKey(tmpNode.hd)) {
                hashMap.put(tmpNode.hd, tmpNode.node);
            }
            if (tmpNode.node.left != null) {
                q.add(new QueueObj(tmpNode.node.left, tmpNode.hd - 1));
                minLevel = Math.min(minLevel,tmpNode.hd - 1);
            }
            if (tmpNode.node.right != null) {
                q.add(new QueueObj(tmpNode.node.right, tmpNode.hd + 1));
                maxLevel = Math.max(maxLevel,tmpNode.hd + 1);
            }
        }
        for (int i = minLevel;i<=maxLevel;i++){
            System.out.print(hashMap.get(i).data + " ");
        }
    }

    public static void main(String[] args) {
        TopViewOfBinaryTree2 tree = new TopViewOfBinaryTree2();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.left.right.right = new Node(5);
        tree.root.left.right.right.right = new Node(6);
        System.out.println("Following are nodes in top view of Binary Tree");
        tree.topview(tree.root);
    }

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }
}
