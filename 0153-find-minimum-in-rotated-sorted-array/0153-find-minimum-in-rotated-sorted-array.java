import java.util.*;

class Solution {
    public int findMin(int[] nums) {
        int low=0;
        int high=nums.length-1;
        int mini=Integer.MAX_VALUE;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[low]<=nums[mid]){
                mini=Math.min(mini,nums[low]);
                low=mid+1;
            }else{
                mini=Math.min(mini,nums[mid]);
                high=mid-1;

            }
            

        }
        return mini;
    }
}