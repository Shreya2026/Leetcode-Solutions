class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            int greatest=-1;
            int j=nums2.length-1;
            while(j>=0 &&nums1[i]!=nums2[j]){
                if(nums2[j]>nums1[i]){
                    greatest=nums2[j];
                }
                j--;
            }
            ans[i]=greatest;
        }
        return ans;
    }
}