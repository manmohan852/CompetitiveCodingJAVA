package site.leetcode.DFS;

import java.util.ArrayList;
import java.util.HashSet;
//Question: Given a target node in a directed graph, find the shortest cycle including this node,
// return the whole path.
public class ShortestCycleInGraph {

    class Node {
        public int value;
        public Node next;

        public Node(int x) {
            value = x;
            next = null;
        }
    }

    class Path {
        public ArrayList<Node> path;

        public Path(ArrayList<Node> path) {
            this.path = path;
        }

    }

    public Path getShortestCycle(Node a) {
        Node current = a;
        HashSet<Node> visited = new HashSet<>();
        while (current.next != null) {
            if (!visited.contains(current)) {
                visited.add(current);
            } else { // We have found the start node for the cycle!
                return computePath(current);
            }
            current = current.next;
        }
        return null; // Could not find path
    }

    // Computes the cycle starting at node a
    private Path computePath(Node a) {
        Node current = a;
        ArrayList<Node> path = new ArrayList<>();
        while (current != a && current.next != null) {
            if (current.next == a) {
                path.add(current);
                path.add(a);
                return new Path(path);
            } else {
                path.add(current);
            }
            current = current.next;
        }
        return null; // Could not find path.
    }
}
