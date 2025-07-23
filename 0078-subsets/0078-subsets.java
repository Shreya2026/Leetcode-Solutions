class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        generate(0,result,new ArrayList<>(),nums);
        return result;
    }

    private void generate(int index,List<List<Integer>> result,List<Integer> current,int[] nums){
        if(index==nums.length){
            result.add(new ArrayList<>(current));
            return;
        }

        //Exclude
        generate(index+1,result,current,nums);

        //Include
        current.add(nums[index]);
        generate(index + 1, result, current, nums);
        current.remove(current.size() - 1);
    }
}