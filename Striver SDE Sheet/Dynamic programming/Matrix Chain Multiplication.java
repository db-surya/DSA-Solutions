class Solution{
    static int matrixMultiply(int i, int j, int[] arr, int[][]dp){
        if(i==j) return 0;
        int mini = Integer.MAX_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];
        for(int k=i;k<j;k++){
            int steps = (arr[i-1]*arr[k]*arr[j])
            +matrixMultiply(i,k,arr,dp)+matrixMultiply(k+1,j,arr,dp);
            mini = Math.min(steps,mini);
        }
        return dp[i][j]=mini;
    }
    static int matrixMultiplication(int N, int arr[])
    {
        // code here
        int dp[][] = new int[N][N];
        for(int[]row:dp){
            Arrays.fill(row,-1);
        }
        return matrixMultiply(1,N-1,arr,dp);
    }
}