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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,List<int[]>> map=new TreeMap<>();
        Queue<NodeInfo> q=new LinkedList<>();
        q.offer(new NodeInfo(root,0,0));

        while(!q.isEmpty()){
            NodeInfo current=q.poll();
            TreeNode node=current.node;
            int row=current.row;
            int col=current.col;

            map.putIfAbsent(col,new ArrayList<>());
            map.get(col).add(new int[]{row,node.val});

            if(node.left!=null){
                q.offer(new NodeInfo(node.left,row+1,col-1));
            }
            if(node.right!=null){
                q.offer(new NodeInfo(node.right,row+1,col+1));
            }
        }
                    List<List<Integer>> ans = new ArrayList<>();

        for(List<int[]> list:map.values()){
            list.sort((a,b)->{
                if(a[0]==b[0]) return a[1]-b[1];
                return a[0]-b[0];
            });

        List<Integer> colList=new ArrayList<>();
         for (int[] p : list) {
                colList.add(p[1]);  // add node value
            }
            ans.add(colList);
        }
        return ans;
        
    }
    static class NodeInfo{
            TreeNode node;
            int row;
            int col;
              NodeInfo(TreeNode n, int r, int c) {
            node = n;
            row = r;
            col = c;
        }
    }
}