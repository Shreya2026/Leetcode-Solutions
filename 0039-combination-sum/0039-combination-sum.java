class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        findCombinations(0,candidates,target,result,new ArrayList<>());
        return result;
    }

    private void findCombinations(int ind,int[] candidates,int target,List<List<Integer>> result,List<Integer> current){
        if(ind==candidates.length){
            if(target==0){
                result.add(new ArrayList<>(current));
            }
            return;
        }
        if(candidates[ind]<=target){
            current.add(candidates[ind]);
            findCombinations(ind,candidates,target-candidates[ind],result,current);
            current.remove(current.size()-1);
        }
        findCombinations(ind+1,candidates,target,result,current);


    }
}