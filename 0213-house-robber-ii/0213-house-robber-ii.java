class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];  // only one house
        if (n == 2) return Math.max(nums[0], nums[1]); // two houses, pick max
        int case1=robLinear(nums,0,n-2);
        int case2=robLinear(nums,1,n-1);
        return Math.max(case1,case2);
    }

    private int robLinear(int[] nums, int start, int end) {
        int prev2 = 0, prev1 = 0;
        for (int i = start; i <= end; i++) {
            int curr = Math.max(nums[i] + prev2, prev1);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}