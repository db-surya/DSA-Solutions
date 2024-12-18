class Solution {
    public int DFS(int i,int j, int prev,int[][] matrix, int[][] dp, int ans){
        if(i<0 || i>=matrix.length || j<0 || j>=matrix[0].length || matrix[i][j]<=prev)
            return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int res =1;
        res = Math.max(res, 1+DFS(i-1,j,matrix[i][j],matrix,dp,ans));
        res = Math.max(res, 1+DFS(i,j-1,matrix[i][j],matrix,dp,ans));
        res = Math.max(res, 1+DFS(i,j+1,matrix[i][j],matrix,dp,ans));
        res = Math.max(res, 1+DFS(i+1,j,matrix[i][j],matrix,dp,ans));
        dp[i][j] = res;
        ans = Math.max(res,ans);
        return res;
    }

    public int longestIncreasingPath(int[][] matrix) {
        int[][]dp = new int[matrix.length][matrix[0].length];
        for(int[]rows:dp){
            Arrays.fill(rows,-1);
        }
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                dp[i][j] = DFS(i,j,-1,matrix,dp,ans);
            }
        }
        int result = Integer.MIN_VALUE;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                result = Math.max(result, dp[i][j]);
            }
        }
        return result;
    }
}