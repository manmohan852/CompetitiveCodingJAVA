package site.leetcode.stack;

import java.util.Stack;

//https://leetcode.com/problems/simplify-path/
public class SimplifyPath {

    public static String simplifyPath(String path) {
        if (path.isEmpty()) {
            return path;
        }
        Stack<String> stack = new Stack<String>();
        String[] components = path.split("/");
        for (String directory : components) {
            if (directory.equals(".") || directory.isEmpty()) {
                continue;
            } else if (directory.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.add(directory);
            }
        }

        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append(dir);
            result.append("/");
        }

        return result.length() > 0 ? result.reverse().toString() : "/";
    }

    public static void main(String[] args) {
        String ss = "/home//foo/";
        String sss = "/../";
        simplifyPath(ss);
    }
}
