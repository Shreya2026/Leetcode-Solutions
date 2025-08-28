class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor=image[sr][sc];
        if (oldColor == color) return image;

        int rows = image.length, cols = image[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});

        while(!queue.isEmpty()){
            int[] cell=queue.poll();
            int r=cell[0],c=cell[1];

            if(r<0||c<0||r>=rows||c>=cols) continue;
            if(image[r][c]!=oldColor) continue;

            image[r][c]=color;
            queue.add(new int[]{r+1, c});
            queue.add(new int[]{r-1, c});
            queue.add(new int[]{r, c+1});
            queue.add(new int[]{r, c-1});
        }
        return image;
    }
}