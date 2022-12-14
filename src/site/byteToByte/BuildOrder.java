package site.byteToByte;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
//https://www.byte-by-byte.com/buildorder/?utm_source=optin_carrot&utm_medium=pdf&utm_campaign=50questions
public class BuildOrder {

    // Perform topological sort
// Input is a list of dependencies where the index is the process number
// and the value is the numbers the processes it depends on
    public static List<Integer> buildOrder(int[][] processes) {
        Set<Integer> temporaryMarks = new HashSet<>();
        Set<Integer> permanentMarks = new HashSet<Integer>();
        List<Integer> result = new LinkedList<>();

        // Recursively search from any unmarked node
        for (int i = 0; i < processes.length; i++) {
            if (!permanentMarks.contains(i)) {
                visit(i, processes, temporaryMarks, permanentMarks, result);
            }
        }

        return result;
    }

    // Search through all unmarked nodes accessible from process
    public static void visit(int process, int[][] processes, Set<Integer> temporaryMarks, Set<Integer> permanentMarks, List<Integer> result) {
        // Throw an error if we find a cycle
        if (temporaryMarks.contains(process))
            throw new RuntimeException("Graph is not acyclic");

        // If we haven't visited the node, recursively search from there
        if (!permanentMarks.contains(process)) {
            temporaryMarks.add(process);

            // Perform recursive search from children
            for (int i : processes[process]) {
                visit(i, processes, temporaryMarks, permanentMarks, result);
            }

            // Add permanent mark, remove temporary mark, and add to results list
            permanentMarks.add(process);
            temporaryMarks.remove(process);
            result.add(process);
        }
    }

    //topological sort
    public static boolean canFinish3(int numCourses, int[][] processes) {
        Set<Integer> temporaryMarks = new HashSet<>();
        Set<Integer> permanentMarks = new HashSet<>();
        for (int i = 0; i < processes.length; i++) {
            if (!permanentMarks.contains(i)) {
                boolean res = visit(i, processes, temporaryMarks, permanentMarks);
                if (res == false) return false;
            }
        }
        return true;
    }

    public static boolean visit(int process, int[][] processes, Set<Integer> temporaryMarks, Set<Integer> permanentMarks) {
        if (temporaryMarks.contains(process))
            return false;
        if (!permanentMarks.contains(process)) {
            temporaryMarks.add(process);
            for (int i : processes[process]) {
                boolean res = visit(i, processes, temporaryMarks, permanentMarks);
                if (res == false) return false;
            }
            permanentMarks.add(process);
            temporaryMarks.remove(process);
        }
        return true;
    }

    public static void main(String[] args) {
        int numOfCourse = 2;
        //int[][] prerequisites = {{1},{0}};//0 has dependecies of 1, 1 has dependencies of 0, hence circle exist,, result = false;
        int[][] prerequisites = {{}, {0}};//0 has dependecies of noone, 1 has dependencies of 0, result = true;
        canFinish3(numOfCourse, prerequisites);
    }
}
