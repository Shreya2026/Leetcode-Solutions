//My Solution
/*class Solution {
    public int majorityElement(int[] nums) {
        int n=nums.length;
        int range=n/2;
        Arrays.sort(nums);
        int count=1;
        for(int i=0;i<n-1;i++){
            if(nums[i]==nums[i+1]){
                count++;
                if(count>range) return nums[i];
            }else{count=1;}
            
        }
        return -1;
    }
}*/

//BRUTE FORCE - O(n^2)
/*class Solution {
    public int majorityElement(int[] nums) {
        int count;
        int n=nums.length;
        for (int i=0;i<n;i++){
            count=0;
            for(int j=0;j<n;j++){
                if(nums[i]==nums[j]){
                    count++;
                }
                if(count>n/2){
                    return nums[i];
                }
            }
        }
        return -1;
    }
}*/

//BETTER SOLUTION - HASHING
/*class Solution{
    public int majorityElement(int[] nums){
        int n=nums.length;
        Map<Integer,Integer> map=new HashMap<>();

        //storing the elements with its occurnce:
        for(int i=0;i<n;i++){
            int count=map.getOrDefault(nums[i],0);
            map.put(nums[i],count+1);
        }


         //searching for the majority element:
        for(Map.Entry<Integer,Integer> it:map.entrySet()){
            if(it.getValue()>n/2){
                return it.getKey();
            }
        }
        return -1;
    }
}*/

//OPTIMAL SOLUTION - Time Complexity-O(n) and S.C.=O(1)
class Solution{
    public int majorityElement(int[] nums){
        int n=nums.length;
        int cnt=0;
        int ele=0;
        for(int i=0;i<n;i++){
            if(cnt==0){
                cnt++;
                ele=nums[i];
            }else if(nums[i]==ele){
                cnt++;
            }
            else{
                cnt--;
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(nums[i]==ele){
                count++;
            }
        }
        if(count>n/2) return ele;
        return -1;
    }
}