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
    public int maxPathSum(TreeNode root) {
        int[] diameter=new int[1];
        height(root,diameter);
        return diameter[0];
    }
    int height(TreeNode root,int[] diameter){
        if(root==null) return 0;
        int lh=Math.max(0,height(root.left,diameter));
        int rh=Math.max(0,height(root.right,diameter));

        diameter[0]=Math.max(lh+rh+root.val,diameter[0]);       
        return root.val+Math.max(lh,rh);
}
}