package site.byteToByte;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class StringDeletion {
    public int delete(String query, HashSet dictionary) {
        Queue<String> queue = new LinkedList();
        Set<String> queueElements = new HashSet();

        queue.add(query);
        queueElements.add(query);

        while (!queue.isEmpty()) {
            String s = queue.remove();
            queueElements.remove(s);
            if (dictionary.contains(s))
                return query.length() - s.length();

            for (int i = 0; i < s.length(); i++) {
                String sub = s.substring(0, i) + s.substring(i + 1, s.length());
                if (sub.length() > 0 && !queueElements.contains(sub)) {
                    queue.add(sub);
                    queueElements.add(sub);
                }
            }
        }
        return -1;
    }
}
