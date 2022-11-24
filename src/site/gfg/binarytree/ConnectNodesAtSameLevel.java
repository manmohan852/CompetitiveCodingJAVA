package site.gfg.binarytree;

import java.util.*;
//https://www.geeksforgeeks.org/connect-nodes-at-same-level-with-o1-extra-space/
//asked in amazon dated 1 August
public class ConnectNodesAtSameLevel {

    static class Node {
        int data;
        Node left, right, nextRight;

        Node(int item) {
            data = item;
            left = right = nextRight = null;
        }
    }

    //Time Complexity: O(n)
    //Space Complexity: O(n)
    static void connect(Node p) {
        // initialize queue to hold nodes at same level
        Queue<Node> q = new LinkedList<>();
        q.add(p); // adding nodes to tehe queue

        Node temp = null; // initializing prev to null
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                Node prev = temp;
                temp = q.poll();

                // i > 0 because when i is 0 prev points
                // the last node of previous level,
                // so we skip it
                if (i > 0)
                    prev.nextRight = temp;

                if (temp.left != null)
                    q.add(temp.left);

                if (temp.right != null)
                    q.add(temp.right);
            }

            // pointing last node of the nth level to null
            temp.nextRight = null;
        }
    }

    /* This function returns the leftmost child of nodes at the same level
    as p. This function is used to getNExt right of p's right child
    If right child of is NULL then this can also be used for the
    left child */
    static Node getNextRight(Node p) {
        Node temp = p.nextRight;

		/* Traverse nodes at p's level and find and return
		the first node's first child */
        while (temp != null) {
            if (temp.left != null)
                return temp.left;
            if (temp.right != null)
                return temp.right;
            temp = temp.nextRight;
        }

        // If all the nodes at p's level are leaf nodes then return NULL
        return null;
    }

    //Method 2: Contant Space
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    /* Sets nextRight of all nodes of a tree with root as p */
    static void connect2(Node p) {
        Node temp = null;

        if (p == null)
            return;

        // Set nextRight for root
        p.nextRight = null;

        // set nextRight of all levels one by one
        while (p != null) {
            Node q = p;

			/* Connect all childrem nodes of p and children nodes of all other
			nodes at same level as p */
            while (q != null) {
                // Set the nextRight pointer for p's left child
                if (q.left != null) {

                    // If q has right child, then right child is nextRight of
                    // p and we also need to set nextRight of right child
                    if (q.right != null)
                        q.left.nextRight = q.right;
                    else
                        q.left.nextRight = getNextRight(q);
                }

                if (q.right != null)
                    q.right.nextRight = getNextRight(q);

                // Set nextRight for other nodes in pre order fashion
                q = q.nextRight;
            }

            // start from the first node of next level
            if (p.left != null)
                p = p.left;
            else if (p.right != null)
                p = p.right;
            else
                p = getNextRight(p);
        }
    }

    public static void main(String args[]) {
		/* Constructed binary tree is
			   10
			 /    \
		    8	   2
		   /
	      3
		*/
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);

        // Populates nextRight pointer in all nodes
        connect(root);

        // Let us check the values of nextRight pointers
        System.out.println("Following are populated nextRight pointers in "
                + "the tree"
                + "(-1 is printed if there is no nextRight)");
        int a = root.nextRight != null ? root.nextRight.data : -1;
        System.out.println("nextRight of " + root.data + " is "
                + a);
        int b = root.left.nextRight != null ? root.left.nextRight.data : -1;
        System.out.println("nextRight of " + root.left.data + " is "
                + b);
        int c = root.right.nextRight != null ? root.right.nextRight.data : -1;
        System.out.println("nextRight of " + root.right.data + " is "
                + c);
        int d = root.left.left.nextRight != null ? root.left.left.nextRight.data : -1;
        System.out.println("nextRight of " + root.left.left.data + " is "
                + d);
    }
}



