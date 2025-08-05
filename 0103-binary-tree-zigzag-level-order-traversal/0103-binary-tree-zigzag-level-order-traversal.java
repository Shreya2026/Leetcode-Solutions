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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean leftToRight = true;

        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> sublist = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                // Depending on direction, add element appropriately
                if (leftToRight) {
                    sublist.addLast(node.val);
                } else {
                    sublist.addFirst(node.val);
                }

                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            ans.add(sublist);
            leftToRight = !leftToRight;  // flip direction for next level
        }
        return ans;
    }
}
