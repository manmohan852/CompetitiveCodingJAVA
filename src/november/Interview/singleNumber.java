package november.Interview;

import java.util.ArrayList;
import java.util.List;

public class singleNumber {
    public static void main(String[] args) {
        int[] nums = {2, 3, 3, 4, 4,2, 7, 5};
        int ans = singleNumber(nums);
        System.out.println(ans);

    }
    public static int singleNumber(int[] nums) {
        List<Integer> no_duplicate_list = new ArrayList<>();

        for (int i : nums) {
            if (!no_duplicate_list.contains(i)) {
                no_duplicate_list.add(i);
            } else {
                no_duplicate_list.remove(new Integer(i));
            }
        }
        return no_duplicate_list.get(0);
    }
}