/*class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<>();
         char[] arr = new char[2*n];
        allParenthesis(0,arr,result,n);
        return result;
    }
    private void allParenthesis(int index,char[] arr,List<String> result,int n){
        if(index==2*n){
            if(isValid(arr,n)){
                result.add(new String(arr));
            }
            return;
        }

        arr[index]='(';
        allParenthesis(index+1,arr,result,n);

        arr[index]=')';
        allParenthesis(index+1,arr,result,n);

    }

    private boolean isValid(char[] arr,int n){
        int balance = 0;
        for (char c : arr) {
            if (c == '(') balance++;
            else balance--;

            // Invalid if closing more than opening
            if (balance < 0) return false;
        }
        return balance == 0;
    }
}*/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<>();
         char[] arr = new char[2*n];
        backtrack(0,0,0,arr,result,n);
        return result;
    }
    private void backtrack(int index,int open, int close, char[] arr,List<String> result,int n){
        if(index==2*n){
            result.add(new String(arr));
            return;
        }

        if(open<n){
            arr[index]='(';
            backtrack(index+1,open+1,close,arr,result,n);
        }

        if(close<open){
            arr[index]=')';
            backtrack(index+1,open,close+1,arr,result,n);
        }

    }
}