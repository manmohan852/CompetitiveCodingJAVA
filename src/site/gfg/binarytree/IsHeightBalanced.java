package site.gfg.binarytree;

//https://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/
public class IsHeightBalanced {

    static class Node {
        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    static class BinaryTree {
        Node root;


        //Time Complexity: O(n^2) Worst case occurs in case of skewed tree.
        boolean isBalanced(Node node) {
            int lh;
            int rh;
            if (node == null)
                return true;
            lh = height(node.left);
            rh = height(node.right);
            if (Math.abs(lh - rh) <= 1
                    && isBalanced(node.left)
                    && isBalanced(node.right))
                return true;
            return false;
        }

        int height(Node node) {
            if (node == null)
                return 0;
            return 1 + Math.max(height(node.left), height(node.right));
        }

        static class Height {
            int height = 0;
        }

        //Time Complexity: O(n)
        boolean isBalanced2(Node root, Height height) {
            if (root == null) {
                height.height = 0;
                return true;
            }
            Height lheight = new Height(), rheight = new Height();
            boolean l = isBalanced2(root.left, lheight);
            boolean r = isBalanced2(root.right, rheight);
            int lh = lheight.height, rh = rheight.height;
            height.height = (lh > rh ? lh : rh) + 1;
            if (Math.abs(lh - rh) >= 2)
                return false;
            else
                return l && r;
        }

        public static void main(String args[]) {
            BinaryTree tree = new BinaryTree();
            tree.root = new Node(1);
            tree.root.left = new Node(2);
            tree.root.right = new Node(3);
            tree.root.left.left = new Node(4);
            tree.root.left.right = new Node(5);
            tree.root.left.left.left = new Node(8);

            if (tree.isBalanced(tree.root))
                System.out.println("Tree is balanced");
            else
                System.out.println("Tree is not balanced");
        }
    }
}

