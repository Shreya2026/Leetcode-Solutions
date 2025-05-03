//BRUTE FORCE SOLUTION- Merge sort

//BETTER SOLUTION
/*class Solution {
    int count0=0;
    int count1=0;
    int count2=0;
    public void sortColors(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0) count0++;
            if(nums[i]==1) count1++;
            if(nums[i]==2) count2++;
        }
        for(int i=0;i<count0;i++){
            nums[i]=0;
        }
        for(int i=count0;i<count0+count1;i++){
            nums[i]=1;
        }
        for(int i=count0+count1;i<nums.length;i++){
            nums[i]=2;
        }
    }
}*/

//OPTIMAL SOLUTION - Dutch National Flag Algorithm
class Solution{
    public void sortColors(int[] nums){
        int low=0;
        int mid=0;
        int high=nums.length-1;
        while(mid<=high){
            if(nums[mid]==0){
                swap(nums,low,mid);
                low++;
                mid++;
            }
            else if(nums[mid]==1){
                mid++;
            } 
            else{
                swap(nums,mid,high);
                high--;
            }
        }
    }
    private void swap(int[] nums, int i, int j){
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
}

}