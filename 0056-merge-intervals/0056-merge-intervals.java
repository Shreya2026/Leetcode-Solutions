import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][0];

        // Sort by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] current = intervals[0];
        merged.add(current);

        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];

            if (next[0] <= current[1]) {
                // Overlapping → merge
                current[1] = Math.max(current[1], next[1]);
            } else {
                // No overlap → new interval
                current = next;
                merged.add(current);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}


/*
| Type  | Complexity               |
| ----- | ------------------------ |
| Time  | **O(n log n)** (sorting) |
| Space | **O(n)** (output list)   |

*/