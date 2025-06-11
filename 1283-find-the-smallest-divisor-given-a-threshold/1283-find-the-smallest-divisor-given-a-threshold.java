class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n=nums.length;
        int maxi=Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            maxi=Math.max(maxi,nums[i]);
        }

        int low=1,high=maxi;

        while(low<=high){
            int mid=low+(high-low)/2;

            int sum=0;
            if(n>threshold) return -1;
            for(int i=0;i<n;i++){
                sum+=Math.ceil((double)nums[i]/(double)mid);
            }

            if(sum<=threshold){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}