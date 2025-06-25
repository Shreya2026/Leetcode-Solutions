/*class Solution {
    public String reverseWords(String s) {
        int end=s.length();
        StringBuilder str=new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)==' '){
                if(i+1<end){
                    str.append(s.substring(i+1,end));
                    str.append(" ");
                }
                
                end=i;
            }
        }
        if(0<end) str.append(s.substring(0,end));
        return str.toString().trim();
    }
}*/

class Solution {
    public String reverseWords(String s) {
        StringBuilder str=new StringBuilder();
        String[] words=s.trim().split("\\s+");
        for(int i=words.length-1;i>=0;i--){
            str.append(words[i]);
            if(i>0) str.append(" ");
        }
        return str.toString();
    }
}