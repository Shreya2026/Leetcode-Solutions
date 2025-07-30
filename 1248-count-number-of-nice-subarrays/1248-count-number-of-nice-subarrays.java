class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return helper(nums,k)-helper(nums,k-1);
    }

    private int helper(int[] nums,int k){
        int cnt=0,left=0,right=0;
        int ans=0;

        while(right<nums.length){
            if(nums[right]%2!=0){
                cnt++;
            }
            while(cnt>k){
                if(nums[left]%2!=0){  
                cnt--;
                }
                left++;
            }
            ans+=(right-left+1);
            right++;
        }
        return ans;
    }
}