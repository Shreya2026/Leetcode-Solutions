class Solution {
    public boolean isAnagram(String s, String t) {
        int s1=s.length();
        int t1=t.length();
        if(s1!=t1){
            return false;
        }
        int[] arr=new int[26];
        for(int i=0;i<s1;i++){
            arr[s.charAt(i)-'a']++;
        }
        for(int i=0;i<s1;i++){
            arr[t.charAt(i)-'a']--;
            if(arr[t.charAt(i)-'a']==-1){
                return false;
            }
        }
        return true;
    }
}