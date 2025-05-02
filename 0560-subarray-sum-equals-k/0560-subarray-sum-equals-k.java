//Brute Force approx O(n^3) --> O(n^2) at best case
/*class Solution {
    public int subarraySum(int[] nums, int k) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){       
                int sum=0;
                //rather than 1 more loop after j loop sum+=nums[j] and sum 
                before j
                for(int l=i;l<=j;l++){ 
                    sum+=nums[l];                 
                }
                if(sum==k) count++;
            }
        }
        return count;
    }
}*/

//Better Solution
/*class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        int left=0;
        int right=0;
        int count=0;
        int sum=nums[0];
        while(right<n){
            // if sum > k, reduce the subarray from left
            // until sum becomes less or equal to k:
            while(left<=right && sum>k){
                sum-=nums[left];
                left++;
            }
            // if sum = k, update the maxLen i.e. answer:
            if(sum==k) count++;
            right++;
            if(right<n) sum+=nums[right];
        }
        return count;
    }
}*/

//Optimal Solution - Hashing  
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> prefixSum=new HashMap<>();
        int count=0;
        int sum=0;
        for(int i=0;i<nums.length;i++){
             //calculate the prefix sum till index i:
            sum+=nums[i];
            // if the sum = k, update the count:
            if(sum==k) count++;
            // calculate the sum of remaining part i.e. x-k:
            int rem=sum-k;
            //Calculate the length and update maxLen:
            if(prefixSum.containsKey(rem)){
                count++;
            }

            //Finally, update the map checking the conditions:
            if(!prefixSum.containsKey(sum)){
                prefixSum.put(sum,i);
            }
        }
        return count;
    }
}