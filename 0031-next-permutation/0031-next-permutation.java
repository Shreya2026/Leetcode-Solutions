class Solution {
    public void nextPermutation(int[] nums) {
        
        int n=nums.length;

        // Step 1: Find the break point:
        int index=-1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                index=i;
                break;
            }
        }
        // If break point does not exist
        if(index==-1){
            // reverse the whole array:
            reverse(nums,0,n-1);
            return;
            
        }

        // Step 2: Find the next greater element
        //         and swap it with arr[ind]:
        for(int i=n-1;i>index;i++){
            if(nums[i]>nums[index]){
                swap(nums,i,index);
                break;
            }
        }

        // Step 3: reverse the right half:
        reverse(nums,index+1,n-1);
    }
    private void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    private void reverse(int[] nums,int start,int end){
        while(start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
}