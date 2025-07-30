class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return countSubarrays(nums,goal)-countSubarrays(nums,goal-1);
    }

    private int countSubarrays(int[] nums,int goal){
        int left=0,right=0,sum=0,cnt=0;
        if(goal<0) return 0;
        while(right<nums.length){
            sum+=nums[right];
            while(sum>goal){
                sum-=nums[left];
                left++;
            }
            cnt+=(right-left+1);
            right++;
        }
        return cnt;
    }
}