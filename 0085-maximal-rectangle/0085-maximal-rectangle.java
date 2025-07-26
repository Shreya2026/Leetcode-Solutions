class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0) return 0;
        int n=matrix[0].length;
        int[] heights=new int[n];
        int maxArea=0;
        for(char[] row:matrix){
            for(int j=0;j<n;j++){
                heights[j]=row[j]=='1'?heights[j]+1:0;
            }
             maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }


    // Leetcode 84: Largest Rectangle in Histogram (with stack)
    private int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> st = new Stack<>();

        // NSR (Next Smaller to Right)
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        st.clear();

        // NSL (Next Smaller to Left)
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = right[i] - left[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}