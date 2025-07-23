class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        findSubsets(0,nums,ans,new ArrayList<>());
        return ans;
    }

    private void findSubsets(int ind,int[] nums,List<List<Integer>> ans,List<Integer> current){
        ans.add(new ArrayList<>(current));

        for(int i=ind;i<nums.length;i++){
            if(i>ind && nums[i]==nums[i-1]) continue;
            current.add(nums[i]);
            findSubsets(i+1,nums,ans,current);
            current.remove(current.size()-1);
        }
    }
}