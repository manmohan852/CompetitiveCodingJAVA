package site.interview.airtelAfrica;

import java.util.*;

public class NestedListIteratorUsingStack {

    private static Deque<Object> stack;

    public static void main(String[] args) {
        List<Object> nestedList = lst(1, lst(2, lst(3, 4)), lst(5, 6, 7), 8, lst(lst(9, 10)));
        List<Integer> flatList = flatten(nestedList);
        System.out.println(nestedList);
        System.out.println(flatList);
    }

    private static List<Integer> flatten(List<Object> nestedList) {
        stack = new ArrayDeque<>();
        List<Integer> ret = new LinkedList<>();
        for (int i = 0; i < nestedList.size(); i++) {
            stack.addLast(nestedList.get(i));
        }

        while (!stack.isEmpty()) {
            if (stack.peekFirst() instanceof List<?>) {
                List<Object> tempNestedList = (List<Object>) stack.removeFirst();
                for (int i = tempNestedList.size() - 1; i >= 0; i--) {
                    stack.addFirst(tempNestedList.get(i));
                }
            } else {
                ret.add((Integer) stack.removeFirst());
            }
        }
        return ret;
    }

    private static List<Object> lst(Object... objs) {
        return Arrays.asList(objs);
    }


}