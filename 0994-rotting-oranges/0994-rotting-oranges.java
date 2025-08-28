class Solution {
    public int orangesRotting(int[][] grid) {
        int rows=grid.length;
        int cols=grid[0].length;

        Queue<int[]> q=new LinkedList<>();
        int freshCount=0;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }else if(grid[i][j]==1){
                    freshCount++;
                }
            }
        }
        if(freshCount==0) return 0;

        int minutes=-1;
        int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};

        //BFS
        while(!q.isEmpty()){
            minutes++;
            int size=q.size();

            for(int i=0;i<size;i++){
                int cell[]=q.poll();
                int r=cell[0],c=cell[1];
                for (int[] dir : directions){
                    int nr=r+dir[0];
                    int nc=c+dir[1];

                    if(nr>=0&&nc>=0&&nr<rows&&nc<cols&&grid[nr][nc]==1){
                        grid[nr][nc] = 2; // make rotten
                        freshCount--;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
        }
        return freshCount==0?minutes:-1;
    }
}