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
import java.util.*;

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Store inorder value -> index in a map for O(1) lookup
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return build(inorder, 0, inorder.length - 1,
                     postorder, 0, postorder.length - 1,
                     inMap);
    }

    private TreeNode build(int[] inorder, int inStart, int inEnd,
                           int[] postorder, int postStart, int postEnd,
                           Map<Integer, Integer> inMap) {

        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        // Last element of postorder is root
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        // Index of root in inorder
        int inRoot = inMap.get(rootVal);

        // Elements left of inRoot are in left subtree
        int numsLeft = inRoot - inStart;

        // Recursively build left and right subtrees
        root.left = build(inorder, inStart, inRoot - 1,
                          postorder, postStart, postStart + numsLeft - 1,
                          inMap);

        root.right = build(inorder, inRoot + 1, inEnd,
                           postorder, postStart + numsLeft, postEnd - 1,
                           inMap);

        return root;
    }
}
