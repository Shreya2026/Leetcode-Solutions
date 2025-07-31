class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return cntSubArrays(nums,k)-cntSubArrays(nums,k-1);
    }

    private int cntSubArrays(int[] nums,int k){
        int left=0;
        int cnt=0;
        Map<Integer,Integer> count=new HashMap<>();
        for(int right=0;right<nums.length;right++){
            count.put(nums[right],count.getOrDefault(nums[right],0)+1);
            if(count.get(nums[right])==1){
                k--;
            }

            while(k<0){
                count.put(nums[left],count.get(nums[left])-1);
                if (count.get(nums[left]) == 0) {
                    count.remove(nums[left]);
                    k++;
                }
                left++;
            }
            cnt+=right-left+1;
        }
        return cnt;
    }
}