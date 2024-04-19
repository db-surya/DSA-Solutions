class Solution
{
    public void shortest_distance(int[][] matrix)
    {
        // convert -1 to infinity
        int n = matrix.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j)
                    matrix[i][j]=0;
                else if(matrix[i][j]==-1)
                    matrix[i][j]=(int)1e8;
            }
        }
        //Floyd warshall
        for(int via=0;via<matrix.length;via++){
            for(int i=0;i<matrix.length;i++){
                for(int j=0;j<matrix[0].length;j++){
                    if(i==via || j==via || i==j)continue;
                    matrix[i][j]=Math.min(matrix[i][j],matrix[i][via]+matrix[via][j]);
                }
            }
        }
        //Convert infinity again to -1 for compilation and tc passing
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==1e8)
                    matrix[i][j]=-1;
            }
        }
    }
}