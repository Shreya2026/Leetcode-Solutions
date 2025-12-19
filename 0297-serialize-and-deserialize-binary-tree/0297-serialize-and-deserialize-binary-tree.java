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

public class Codec {

    // Serialize tree to string
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#,");
            return;
        }
        sb.append(node.val).append(",");
        buildString(node.left, sb);
        buildString(node.right, sb);
    }

    // Deserialize string to tree
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(values));
        return buildTree(queue);
    }

    private TreeNode buildTree(Queue<String> queue) {
        String val = queue.poll();

        if (val.equals("#")) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = buildTree(queue);
        node.right = buildTree(queue);
        return node;
    }
}


/*
Time Complexity

Serialize → O(N)

Deserialize → O(N)

N = number of nodes

Space Complexity

O(N)

Serialized string

Recursion stack (worst case skewed tree)
*/
// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));