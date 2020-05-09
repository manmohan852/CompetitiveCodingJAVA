package site.byteToByte;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPath {
    // Graph node class
    public static class Node {
        int value;
        List<Node> children;

        // Basic constructor
        public Node(int value) {
            this.value = value;
        }

        // Lazily instantiate children list
        public void addChild(Node n) {
            if (this.children == null) this.children = new LinkedList<>();
            this.children.add(n);
        }
    }

    // Find the shortest path between two nodes using BFS
    public static List<Node> shortestPath(Node a, Node b) {
        // Return null if either node is null or if they're the same node
        if (a == null || b == null) return null;
        if (a == b) return null;

        // Using a queue for our BFS
        Queue<Node> toVisit = new LinkedList<Node>();

        // Track the parents so that we can reconstruct our path
        HashMap<Node, Node> parents = new HashMap<Node, Node>();

        // Initialize the BFS
        toVisit.add(a);
        parents.put(a, null);

        // Keep going until we run out of nodes or reach our destination
        while (!toVisit.isEmpty()) {
            Node curr = toVisit.remove();

            // If we find the node we're looking for then we're done
            if (curr == b) break;

            // If the current node doesn't have children, skip it
            if (curr.children == null) continue;

            // Add all the children to the queue
            for (Node n : curr.children) {
                if (!parents.containsKey(n)) {
                    toVisit.add(n);
                    parents.put(n, curr);
                }
            }
        }

        // If we couldn't find a path, the destination node won't have been
        // added to our parents set
        if (parents.get(b) == null) return null;

        // Create the output list and add the path to the list
        List<Node> out = new LinkedList<Node>();
        Node n = b;
        while (n != null) {
            out.add(0, n);
            n = parents.get(n);
        }

        return out;
    }
}
