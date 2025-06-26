/*class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        char[] s1=(s.toCharArray());
        char[] t1=(t.toCharArray());
        Arrays.sort(s1);
        Arrays.sort(t1);

        for(int i=0;i<s.length();i++){                //instead of for loop return Arrays.equals(s1,t1)
            if(s1[i]!=t1[i]) return false;
        }
        return true;
    }
}*/



class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int freq[]=new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
            freq[t.charAt(i)-'a']--;

        }

        for(int count:freq){
            if(count!=0) return false;
        }
        return true;
    }
}