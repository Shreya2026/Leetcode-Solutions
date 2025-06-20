class Solution {

    public int cntPartitions(int[] nums,int k){
        int partitions=1;
        int subarraySum=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]+subarraySum<=k){
                subarraySum=nums[i]+subarraySum;
            }else{
                partitions++;
                subarraySum=nums[i];
            }
        }
        return partitions;
    }

    public int splitArray(int[] nums, int k) {
        int low=nums[0];
        int high=0;
        for(int i=0;i<nums.length;i++){
            low=Math.max(low,nums[i]);
            high+=nums[i];
        }

        while(low<=high){
            int mid=low+(high-low)/2;
            int partition=cntPartitions(nums,mid);
            if(partition>k) low=mid+1;
            else high=mid-1;
        }
        return low;
    }
}