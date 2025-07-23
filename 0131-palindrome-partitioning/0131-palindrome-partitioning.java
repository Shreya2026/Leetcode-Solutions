class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        List<String> path=new ArrayList<>();
        backtrack(0,path,res,s);
        return res;
    }

    private void backtrack(int idx,List<String> path,List<List<String>> res,String s){
        if(idx==s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=idx;i<s.length();i++){
            if(isPalindrome(s,idx,i)){
                path.add(s.substring(idx,i+1));
                backtrack(i+1,path,res,s);
                path.remove(path.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s,int start,int end){
        while(start<=end){
            if(s.charAt(start++)!=s.charAt(end--)) return false;
        }
        return true;
    }
}