package site.leetcode.bst;

import java.util.ArrayList;
import java.util.Stack;

//https://leetcode.com/articles/binary-search-tree-iterator/
public class BinarySearchTreeIterator {

}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

//Time complexity : O(N) is the time taken by the constructor for the iterator.
    //next() would take O(1)O(1)
    //hasNext() would take O(1)O(1)
//Space complexity : O(N)
class BSTIterator1 {

    ArrayList<Integer> nodesSorted;
    int index;

    public BSTIterator1(TreeNode root) {
        // Array containing all the nodes in the sorted order
        this.nodesSorted = new ArrayList<Integer>();
        // Pointer to the next smallest element in the BST
        this.index = -1;
        // Call to flatten the input binary search tree
        this._inorder(root);
    }

    private void _inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        this._inorder(root.left);
        this.nodesSorted.add(root.val);
        this._inorder(root.right);
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return this.nodesSorted.get(++this.index);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return this.index + 1 < this.nodesSorted.size();
    }
}

//Time complexity : O(1) is the time taken by the constructor for the iterator.
        //next() would take O(1): the amortized (average) time complexity for this function would still be O(1)
            // O(N) in the worst case.
        //hasNext() would take O(1)
//Space complexity : O(h)
class BSTIterator {

    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {

        // Stack for the recursion simulation
        this.stack = new Stack<>();

        // Remember that the algorithm starts with a call to the helper function
        // with the root node as the input
        this._leftmostInorder(root);
    }

    private void _leftmostInorder(TreeNode root) {

        // For a given node, add all the elements in the leftmost branch of the tree
        // under it to the stack.
        while (root != null) {
            this.stack.push(root);
            root = root.left;
        }
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        // Node at the top of the stack is the next smallest element
        TreeNode topmostNode = this.stack.pop();

        // Need to maintain the invariant. If the node has a right child, call the
        // helper function for the right child
        if (topmostNode.right != null) {
            this._leftmostInorder(topmostNode.right);
        }

        return topmostNode.val;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return this.stack.size() > 0;
    }
}