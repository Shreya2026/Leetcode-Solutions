class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int[] color=new int[n];
        Arrays.fill(color,-1);

         for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!dfs(graph, i, 0, color)) return false;
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph,int node,int c,int[] color){
        color[node]=c;
        for(int n:graph[node]){
            if(color[n]==-1){
                if(!dfs(graph,n,1-c,color)) return false;
            }else if(color[n]==c) return false;
        }
        return true;
    }
}