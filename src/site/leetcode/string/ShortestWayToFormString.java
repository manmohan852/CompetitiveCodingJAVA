package site.leetcode.string;
//https://leetcode.com/problems/shortest-way-to-form-string/
public class ShortestWayToFormString {

    public int shortestWay(String source, String target) {
        int count = 0;
        // find the index (in source) of the first char in target
        int prev = source.indexOf(target.charAt(0));
        // if not such char exist in source, return -1
        if (prev == -1) return -1;
        // start to look for this char (in target), starting the search at the offset index in source
        int offset = prev + 1;
        for (int i = 1; i < target.length(); i++) {
            int current = source.indexOf(target.charAt(i), offset);
            if (source.indexOf(target.charAt(i)) == -1) return -1;

            // when we cannot find the char (in target), while searching in source, start over
            if (current == -1) {
                offset = source.indexOf(target.charAt(i)) + 1;
                count++;
                prev = current;
                continue;
            }
            if (current < prev) {
                count++;
                // reset offset
                offset = current + 1;
                prev = current;
                continue;
            }
            prev = current;
            offset = prev + 1;
        }
        return count + 1;
    }
}
