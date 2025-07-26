class Solution {
    public String removeKdigits(String num, int k) {
        if(k==num.length()) return "0";

        Stack<Character> st=new Stack<>();
        for(char digit:num.toCharArray()){
            while(!st.isEmpty() && k>0 && st.peek()>digit){
                st.pop();
                k--;
            }
            st.push(digit);
        }

        while(k-->0){
            st.pop();
        }
         StringBuilder sb = new StringBuilder();
        for (char digit :st) {
            sb.append(digit);
        }

        // Remove leading zeros
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }
}