/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int height = getHeight(root);

        if (height == 0) return 1;

        int left = 0;
        int right = (1 << height) - 1;
        int lastLevelCount = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (exists(mid, height, root)) {
                lastLevelCount = mid + 1;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return (1 << height) - 1 + lastLevelCount;
    }

    private int getHeight(TreeNode node) {
        int height = 0;
        while (node.left != null) {
            height++;
            node = node.left;
        }
        return height;
    }

    private boolean exists(int idx, int height, TreeNode node) {
        int left = 0, right = (1 << height) - 1;

        for (int i = 0; i < height; i++) {
            int mid = left + (right - left) / 2;
            if (idx <= mid) {
                node = node.left;
                right = mid;
            } else {
                node = node.right;
                left = mid + 1;
            }
        }
        return node != null;
    }
}


/*
Time Complexity

O(log² N)

Height calculation → O(log N)

Binary search (log N) × node existence check (log N)

Space Complexity

O(1) (no recursion / extra structures)
*/