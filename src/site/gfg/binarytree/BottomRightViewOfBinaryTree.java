package site.gfg.binarytree;
//https://www.geeksforgeeks.org/print-bottom-right-view-of-a-binary-tree/?ref=rp
class BottomRightViewOfBinaryTree {

    Node root;
    Max_level max = new Max_level();

    void bottomRightViewUtil(Node node, int level, Max_level max_level) {
        if (node == null)
            return;
        bottomRightViewUtil(node.right, level, max_level);
        if (max_level.max_level < level) {
            System.out.print(node.data + " ");
            max_level.max_level = level;
        }
        bottomRightViewUtil(node.left, level + 1, max_level);
    }

    void bottomRightView() {
        bottomRightView(root);
    }

    void bottomRightView(Node node) {
        bottomRightViewUtil(node, 1, max);
    }

    public static void main(String args[]) {
        BottomRightViewOfBinaryTree tree = new BottomRightViewOfBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.right.left = new Node(5);
        tree.root.right.left.right = new Node(6);

        tree.bottomRightView();
    }

    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static class Max_level {
        int max_level;
    }
}
