class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        int MOD=(int) 1e9+7;

         Stack<Integer> stack = new Stack<>();
         int[] prev = new int[n];
         int[] next = new int[n];

         //next small ele
         for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            next[i]=stack.isEmpty()?n:stack.peek();
            stack.push(i);
         }

         stack.clear();

         //prev small elements
         for(int i=0;i<n;i++){
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                stack.pop();
            }
            prev[i]=stack.isEmpty()?-1:stack.peek();
            stack.push(i);
         }

         // Now compute the result
         long res=0;
         for(int i=0;i<n;i++){
            long count=(long)((i-prev[i]) * (next[i] - i)) % MOD;
            res=(res+arr[i]*count)%MOD;
         }
         return (int)res;
    }
}