/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;

class Solution {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        // Step 1: build parent map
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        buildParent(root, null, parent);

        // Step 2: BFS from target
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        queue.offer(target);
        visited.add(target);

        int distance = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            if (distance == k) {
                List<Integer> result = new ArrayList<>();
                for (TreeNode node : queue) {
                    result.add(node.val);
                }
                return result;
            }

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                // left child
                if (curr.left != null && !visited.contains(curr.left)) {
                    visited.add(curr.left);
                    queue.offer(curr.left);
                }

                // right child
                if (curr.right != null && !visited.contains(curr.right)) {
                    visited.add(curr.right);
                    queue.offer(curr.right);
                }

                // parent
                TreeNode par = parent.get(curr);
                if (par != null && !visited.contains(par)) {
                    visited.add(par);
                    queue.offer(par);
                }
            }

            distance++;
        }

        return new ArrayList<>();
    }

    private void buildParent(TreeNode node, TreeNode par,
                             Map<TreeNode, TreeNode> parent) {
        if (node == null) return;
        parent.put(node, par);
        buildParent(node.left, node, parent);
        buildParent(node.right, node, parent);
    }
}


/*
Time Complexity

O(N)

DFS to build parent map → O(N)

BFS traversal → O(N)

💾 Space Complexity

O(N)

Parent map + visited set + queue
*/