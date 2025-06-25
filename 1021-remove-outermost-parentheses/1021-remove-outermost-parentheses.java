/*class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder str=new StringBuilder();
        int start=0;
        int open=0;
        int close=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') open++;
            else close++;
            if(open==close && close!=0){
                str.append(s.substring(start+1,i));
                open=0;
                close=0;
                start=i+1;
            }
        }
        return str.toString();
    }
}*/

class Solution {
    public String removeOuterParentheses(String s) {
        int count=0;
        StringBuilder str=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==')') count--;
            if(count!=0) {
                str.append(s.charAt(i));
            }
            if(s.charAt(i)=='(') count++;
        }
        return str.toString();
    }
}