class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        Deque<Integer> dq=new ArrayDeque<>();
        int[] result = new int[n - k + 1];
        int idx = 0;

         for (int i = 0; i < n; i++) {
            // Remove indices out of the current window
            if (!dq.isEmpty() && dq.peek() == i - k)
                dq.poll();

            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[i]){
                dq.pollLast();
            }
            dq.offer(i);

            if(i>=k-1){
                result[idx++]=nums[dq.peek()];
            }
         }
         return result;
    }
}