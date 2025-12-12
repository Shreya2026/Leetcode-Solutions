import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>(); // stores indices, temps strictly decreasing

        for (int i = 0; i < n; i++) {
            // while current day's temp is warmer than the day at stack top, resolve that day
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIdx = stack.pop();
                ans[prevIdx] = i - prevIdx;
            }
            stack.push(i);
        }

        // remaining indices in stack have no warmer future day -> ans entries stay 0
        return ans;
    }
}
