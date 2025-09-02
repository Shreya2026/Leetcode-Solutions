//Better (DP – O(n²))
//Time: O(n²)
//Space: O(n)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxLen = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }
}



//Brute Force (Recursion, Exponential)
/*
class Solution {
    public int lengthOfLIS(int[] nums) {
        return dfs(nums, -1, 0);
    }

    private int dfs(int[] nums, int prevIdx, int currIdx) {
        if (currIdx == nums.length) return 0;

        int take = 0;
        if (prevIdx == -1 || nums[currIdx] > nums[prevIdx]) {
            take = 1 + dfs(nums, currIdx, currIdx + 1);
        }
        int skip = dfs(nums, prevIdx, currIdx + 1);

        return Math.max(take, skip);
    }
}
Time: O(2^n)
Space: O(n) recursion
*/

//Optimal (Binary Search – O(n log n))
/*
class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> sub = new ArrayList<>();

        for (int x : nums) {
            int idx = Collections.binarySearch(sub, x);
            if (idx < 0) idx = -(idx + 1); // insertion point

            if (idx == sub.size()) sub.add(x);
            else sub.set(idx, x);
        }

        return sub.size();
    }
}
Time: O(n log n)
Space: O(n)
*/