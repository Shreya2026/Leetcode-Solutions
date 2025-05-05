//BRUTE FORCE
/*class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        int first=-1;
        int last=-1;
        for(int i=0;i<n;i++){
            if(nums[i]==target){
                if(first==-1) first=i;
                last=i;
            }
        }
        return new int[]{first,last};
    }
}*/


class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first=findFirst(nums,target);
        int last=findLast(nums,target);
        return new int[]{first,last};
    }

    private int findFirst(int[] nums,int target){
        int start=0;
        int end=nums.length-1;
        int index=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                index=mid;
                end=mid-1;
            }
            else if(nums[mid]<target){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return index;
    }

    private int findLast(int[] nums,int target){
        int start=0;
        int end=nums.length-1;
        int index=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                index=mid;
                start=mid+1;
            }
            else if(nums[mid]<target){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return index;
    }
}
