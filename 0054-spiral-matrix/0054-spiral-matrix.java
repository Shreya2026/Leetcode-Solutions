class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // Define ans list to store the result.
        List<Integer> ans = new ArrayList<>();
        
        int n = matrix.length; // no. of rows
        int m = matrix[0].length; // no. of columns
        
        // Initialize the pointers required for traversal.
        int top = 0, left = 0, bottom = n - 1, right = m - 1;

        while(top<=bottom&& left<=right){  
        //right
        for(int i=left;i<=right;i++){
            ans.add(matrix[top][i]);
        }
        top++;

        //down
        for(int i=top;i<=bottom;i++){
            ans.add(matrix[i][right]);
        }
        right--;

        //left
        if(top<=bottom){
        for(int i=right;i>=left;i--){
            ans.add(matrix[bottom][i]);
        }
        bottom--;
        }

        //up
        if(left<=right){
        for(int i=bottom;i>=top;i--){
            ans.add(matrix[i][left]);
        }
         left++;
        }
        }
        return ans;
    }
}