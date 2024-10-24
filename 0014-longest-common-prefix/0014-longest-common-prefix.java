class Solution {
    public String longestCommonPrefix(String[] strs) {
        String ans=strs[0];
        if (strs==null || strs.length==0)return "";
        for(int i=1;i<strs.length;i++){
            int j=0;
           while(j < ans.length() && j < strs[i].length()){
            if(strs[i].charAt(j)!=ans.charAt(j)){
                break;
            }
            j++;
           }
              ans=ans.substring(0,j);
        }
        if(ans.isEmpty()){
            return "";
        }
        return ans;
        }
}