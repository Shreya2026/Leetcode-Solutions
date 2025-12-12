class Solution {
    public boolean isValidSudoku(char[][] board) {
        // rows[r][d] == true if digit d+1 seen in row r
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9]; // box index = (r/3)*3 + (c/3)

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char ch = board[r][c];
                if (ch == '.') continue;
                int d = ch - '1'; // map '1'..'9' -> 0..8
                if (d < 0 || d >= 9) return false; // invalid char guard

                if (rows[r][d]) return false;        // duplicate in row
                if (cols[c][d]) return false;        // duplicate in column

                int b = (r / 3) * 3 + (c / 3);
                if (boxes[b][d]) return false;       // duplicate in box

                rows[r][d] = cols[c][d] = boxes[b][d] = true;
            }
        }
        return true;
    }
}
