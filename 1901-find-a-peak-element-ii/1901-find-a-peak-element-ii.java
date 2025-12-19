class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        int left = 0, right = cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Find row index of max element in mid column
            int maxRow = 0;
            for (int r = 0; r < rows; r++) {
                if (mat[r][mid] > mat[maxRow][mid]) {
                    maxRow = r;
                }
            }

            int leftVal = mid - 1 >= 0 ? mat[maxRow][mid - 1] : -1;
            int rightVal = mid + 1 < cols ? mat[maxRow][mid + 1] : -1;

            if (mat[maxRow][mid] > leftVal && mat[maxRow][mid] > rightVal) {
                return new int[]{maxRow, mid}; // peak found
            } else if (rightVal > mat[maxRow][mid]) {
                left = mid + 1;   // move right
            } else {
                right = mid - 1;  // move left
            }
        }

        return new int[]{-1, -1}; // should never happen
    }
}

/*
| Type  | Complexity     |
| ----- | -------------- |
| Time  | **O(m log n)** |
| Space | **O(1)**       |

*/