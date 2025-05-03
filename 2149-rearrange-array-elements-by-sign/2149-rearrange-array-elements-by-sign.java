//BRUTE FORCE
//T.C-O(2n) && S.C.-O(n)
/*class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] positive=new int[nums.length/2];
        int[] negative=new int[nums.length/2];
        int p=0,n=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0) positive[p++]=nums[i];
            else negative[n++]=nums[i];
        }
        for(int i=0;i<nums.length/2;i++){
            nums[2*i]=positive[i];
            nums[2*i+1]=negative[i];
        }
        return nums;
    }
}*/

//OPTIMAL FORCE
//T.C-O(n) && S.C.-O(n)
class Solution {
    public int[] rearrangeArray(int[] nums) {
        int pos=0;
        int neg=1;
        int[] ans=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                ans[pos]=nums[i];
                pos+=2;
            }else{
                ans[neg]=nums[i];
                neg+=2;
            } 
        }
        return ans;
    }
}
