//My solution - better solution-O(N^2)
// Brute force would be using 3 loops k loop from i to j - O(n^3)
/*class Solution {
    public int maxSubArray(int[] nums) {
        int finalSum=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int sum=0;
            for(int j=i;j<nums.length;j++){
                sum+=nums[j];
                 if(sum>finalSum) finalSum=sum;
            }
        }
        return finalSum;
    }
}*/

//OPTIMAL SOLUTION (Kadane's Algo.)
//T.C-O(n) && S.C.-O(1)
class Solution{
    public int maxSubArray(int[] nums){
        int maxSum=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum>maxSum) maxSum=sum;

             // If sum < 0: discard the sum calculated
            if(sum<0) sum=0;
        }
        // To consider the sum of the empty subarray
        // uncomment the following check:

        //if (maxSum < 0) maxSum = 0;
        return maxSum;
    }
}