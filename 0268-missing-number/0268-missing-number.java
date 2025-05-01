// XOR solution best because XOR cannot exceed 10^5 value that sum solution could
class Solution{
    public int missingNumber(int[] nums){
        int xorAll=0;
        int xorNums=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            xorNums^=nums[i];
            xorAll^=(i+1);
        }
        return xorAll ^ xorNums;
    }
}


//Sum Solution
/*class Solution{
    public int missingNumber(int[] nums){
        int n=nums.length;
        int expectedSum=n*(n+1)/2;
        int actualSum=0;
        for(int num:nums){
            actualSum+=num;
        }
        return (expectedSum-actualSum);
    }
}*/


//My Solution
/*import java.util.Arrays;
class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            if(nums[i]!=i) return i;
        }
        return n;
    }
}
*/