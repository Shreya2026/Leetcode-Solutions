/*class Solution {
    public int maxDepth(String s) {
        Stack<Character> stack=new Stack<>();
        int maxDepth=0;
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)=='('){
                stack.push(s.charAt(i));
                maxDepth=Math.max(maxDepth,stack.size());
            }else if(s.charAt(i)==')'){
                if(!stack.isEmpty()) stack.pop();
            }
        }
        return maxDepth;
    }
}*/

class Solution {
    public int maxDepth(String s) {
        int currentDepth=0;
        int maxDepth=0;
        for(char c:s.toCharArray()){
            if(c=='('){
                currentDepth++;
                maxDepth=Math.max(currentDepth,maxDepth);
            }else if(c==')'){
                currentDepth--;
            }
        }
        return maxDepth;
    }
}