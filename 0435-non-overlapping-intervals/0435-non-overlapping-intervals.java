import java.util.*;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;

        // Step 1: sort by end time
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int removals = 0;
        int lastEnd = intervals[0][1];

        // Step 2: greedy selection
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < lastEnd) {
                // overlap -> remove this interval
                removals++;
            } else {
                // no overlap -> keep it
                lastEnd = intervals[i][1];
            }
        }

        return removals;
    }
}


/*
Time Complexity

O(N log N) — sorting

💾 Space Complexity

O(1) — in-place sorting (ignoring sort stack)
*/