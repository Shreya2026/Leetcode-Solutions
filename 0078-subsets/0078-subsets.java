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

/*

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int total = 1 << n; // 2^n subsets
        List<List<Integer>> result = new ArrayList<>();

        for (int mask = 0; mask < total; mask++) {
            List<Integer> subset = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    subset.add(nums[i]);
                }
            }
            result.add(subset);
        }

        return result;
    }
}
*/