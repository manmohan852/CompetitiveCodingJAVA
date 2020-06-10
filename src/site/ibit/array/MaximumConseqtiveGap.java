package site.ibit.array;

import java.util.Collections;
import java.util.List;

public class MaximumConseqtiveGap {

    public int maximumGap(final List<Integer> nums) {
        if (nums.size() < 2) {
            return 0;
        }
        Collections.sort(nums);
        int max = 0;
        for (int i = 0; i < nums.size() - 1; i++) {
            max = Math.max(nums.get(i + 1) - nums.get(i), max);
        }
        return max;
    }
}
