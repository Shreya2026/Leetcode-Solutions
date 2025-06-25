/*class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        for(int i=0;i<s.length();i++){
            String str=s.substring(i)+s.substring(0,i);
            if(str.equals(goal)) return true;
        }
        return false;
    }
}*/

class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        String combined=s+s;
        return combined.contains(goal);
    }
}