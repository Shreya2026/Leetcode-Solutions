class Solution {
    public int totalNQueens(int n) {
        char[][] board=new char[n][n];
        for(char[] row:board){
            Arrays.fill(row,'.');
        }
        return solve(0,board,n);
    }

    private int solve(int row,char[][] board,int n){
        if (row == n) {
            return 1;
        }

        int cnt=0;
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = 'Q';  // Place queen
                cnt+=solve(row + 1, board, n);  // Recur to next row
                board[row][col] = '.';  // Backtrack
            }
        }
        return cnt;
    }


    private boolean isSafe(char[][] board, int row, int col, int n) {
        // Check column above
        for (int i = 0; i < row; i++)
            if (board[i][col] == 'Q')
                return false;

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q')
                return false;

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++)
            if (board[i][j] == 'Q')
                return false;

        return true;
    }

    // Helper to convert board to List<String> format
    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] row : board)
            res.add(new String(row));
        return res;
    }
}