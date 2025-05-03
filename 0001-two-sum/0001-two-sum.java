//BRUTE FORCE - O(n^2)
/*class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target) return new int[]{i,j};
            }
        }
        return new int[]{-1,-1};
    }
}*/

//OPTIMAL SOLUTION but if onlt yes or no to return then better approach optimal starred 
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int moreNeeded=target-nums[i];
            if(map.containsKey(moreNeeded)){
                return new int[]{map.get(moreNeeded),i};
            } 
            map.put(nums[i],i);           
        }
        return new int[]{-1,-1};
    }
}
