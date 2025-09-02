//Better (DP – O(n²))
//Time: O(n²)
//Space: O(n)
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        int[] parent = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);

        int maxLen = 1, maxIdx = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxIdx = i;
            }
        }

        // Reconstruct subset
        List<Integer> res = new ArrayList<>();
        for (int i = maxIdx; i != -1; i = parent[i]) {
            res.add(nums[i]);
        }
        Collections.reverse(res);
        return res;
    }
}



//Brute Force (Recursion, Exponential)
// Generate all subsets, check divisibility condition, keep the largest.
/*
class Solution {
    private List<Integer> best = new ArrayList<>();

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>());
        return best;
    }

    private void backtrack(int[] nums, int idx, List<Integer> subset) {
        if (subset.size() > best.size()) {
            best = new ArrayList<>(subset);
        }
        for (int i = idx; i < nums.length; i++) {
            if (subset.isEmpty() || nums[i] % subset.get(subset.size() - 1) == 0) {
                subset.add(nums[i]);
                backtrack(nums, i + 1, subset);
                subset.remove(subset.size() - 1);
            }
        }
    }
}
Time: O(2^n)
Space: O(n) recursion
*/