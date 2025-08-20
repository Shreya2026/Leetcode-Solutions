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

 //TC=O(n) AND S.C=O(h)
class Solution {
    public void flatten(TreeNode root) {
        flattenTree(root);
    }

    private TreeNode flattenTree(TreeNode node){
        if(node==null) return null;

        TreeNode leftTail=flattenTree(node.left);
        TreeNode rightTail = flattenTree(node.right);
         if (leftTail != null) {
            leftTail.right = node.right; // attach right subtree after leftTail
            node.right = node.left;      // move left subtree to right
            node.left = null;            // set left to null

           
        } 
        if (rightTail != null) return rightTail;
        if (leftTail != null) return leftTail;
        return node;
    }
}