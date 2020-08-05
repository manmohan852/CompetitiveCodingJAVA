package site.gfg.binarytree;
//https://www.geeksforgeeks.org/find-largest-subtree-having-identical-left-and-right-subtrees/
public class largestSubtreeHavingIdenticalLeftAndrightSubtrees {

    static class Node {
        int data;
        Node left, right;
    }

    static Node newNode(int data) {
        Node node = new Node();
        node.data = data;
        node.left = node.right = null;
        return (node);
    }

    static int maxSize;
    static Node maxNode;

    static class Pair {
        int first;
        String second;

        Pair(int a, String b) {
            first = a;
            second = b;
        }
    }

    static Pair largestSubtreeUtil(Node root, String str) {
        if (root == null)
            return new Pair(0, str);

        String left = "", right = "";

        Pair ls1 = largestSubtreeUtil(root.left, left);
        left = ls1.second;
        int ls = ls1.first;

        Pair rs1 = largestSubtreeUtil(root.right, right);
        right = rs1.second;
        int rs = rs1.first;

        int size = ls + rs + 1;
        if (left.equals(right)) {
            if (size > maxSize) {
                maxSize = size;
                maxNode = root;
            }
        }

        // append left subtree data
        str += "|" + left + "|";

        // append current node data
        str += "|" + root.data + "|";

        // append right subtree data
        str += "|" + right + "|";

        return new Pair(size, str);
    }

    //The worst case time complexity still remains O(n2) as we need O(n) time to compare two strings.
    static int largestSubtree(Node node) {
        maxSize = 0;
        largestSubtreeUtil(node, "");
        return maxSize;
    }

    public static void main(String args[]) {
    /* Let us construct the following Tree
                50
            /     \
            10     60
            / \     / \
            5 20 70 70
                / \ / \
                65 80 65 80 */
        Node root = newNode(50);
        root.left = newNode(10);
        root.right = newNode(60);
        root.left.left = newNode(5);
        root.left.right = newNode(20);
        root.right.left = newNode(70);
        root.right.left.left = newNode(65);
        root.right.left.right = newNode(80);
        root.right.right = newNode(70);
        root.right.right.left = newNode(65);
        root.right.right.right = newNode(80);

        maxNode = null;
        maxSize = largestSubtree(root);

        System.out.println("Largest Subtree is rooted at node "
                + maxNode.data + "\nand its size is "
                + maxSize);
    }
}