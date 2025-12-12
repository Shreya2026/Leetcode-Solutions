import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int best = 0;
        for (int num : set) {
            // only start counting if 'num' is the beginning of a sequence
            if (!set.contains(num - 1)) {
                int curr = num;
                int length = 1;

                while (set.contains(curr + 1)) {
                    curr++;
                    length++;
                }

                best = Math.max(best, length);
            }
        }

        return best;
    }
}
