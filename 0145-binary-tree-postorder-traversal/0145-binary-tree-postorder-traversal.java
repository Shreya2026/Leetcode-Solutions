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

 //RECURSION
 /*
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    private void postorder(TreeNode root, List<Integer> result) {
        if (root == null)
            return;
        postorder(root.left, result);
        postorder(root.right, result);
        result.add(root.val);
    }
}*/
 //USING 2 STACKS
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> st1=new Stack<>();
        Stack<TreeNode> st2=new Stack<>();
        List<Integer> result=new ArrayList<>();
        if(root==null) return result;
        st1.push(root);
        while(!st1.isEmpty()){
            root=st1.pop();
            st2.push(root);
            if(root.left!=null) st1.push(root.left);
            if(root.right!=null) st1.push(root.right);
        }
        while(!st2.isEmpty()){
            result.add(st2.pop().val);
        }
        return result;
    }
}