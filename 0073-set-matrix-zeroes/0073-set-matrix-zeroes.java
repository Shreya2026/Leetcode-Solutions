//My Solution
/*class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> zeroRows = new HashSet<>();
        Set<Integer> zeroCols = new HashSet<>();
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    zeroRows.add(i);
                    zeroCols.add(j);
                }
            }
        }
        for(int row:zeroRows){
            for(int j=0;j<m;j++){
                matrix[row][j]=0;
            }
        }
        for(int col:zeroCols){
            for(int i=0;i<n;i++){
                matrix[i][col]=0;
            }
        }
    }
}*/


//BRUTE FORCE SOLUTION
/*class Solution {
    public void setZeroes(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    markRow(i,m,matrix);
                    markCol(j,n,matrix);
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==-1) matrix[i][j]=0;
            }
        }
    }
    static void markRow(int i,int m,int[][] mat){
        for(int j=0;j<m;j++){
            if(mat[i][j]!=0) mat[i][j]=-1;
        }
    }
    static void markCol(int j,int n,int[][] mat){
        for(int i=0;i<n;i++){
            if(mat[i][j]!=0) mat[i][j]=-1;
        }
    }
}*/

//BETTER APPROACH
/*class Solution {
    public void setZeroes(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int[] row=new int[n];
        int[] col=new int[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    row[i]=1;
                    col[j]=1;
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(row[i]==1||col[j]==1) matrix[i][j]=0;
            }
        }
    }
}*/

//MOST OPTIMAL SOLUTION 
//T.C.=O(n*m) AND S.C.=O(1)
class Solution{
    public void setZeroes(int[][] matrix){
        int col0=1;
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    if(j!=0){
                        matrix[0][j]=0;
                    }else{
                        col0=0;
                    }
                }
            }
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][j]!=0){
                    if(matrix[0][j]==0||matrix[i][0]==0){
                        matrix[i][j]=0;
                    }
                }
            }
        }
        if(matrix[0][0]==0){
            for(int j=0;j<m;j++){
                matrix[0][j]=0;
            }
        }
        if(col0==0){
            for(int i=0;i<n;i++){
                matrix[i][0]=0;
            }
        }
    }
}