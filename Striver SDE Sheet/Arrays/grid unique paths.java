class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][]  = new int[m][n];
        dp[0][0] = 1;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int value = 0;
                if(i==0 && j==0)
                    continue;
                if(i-1>=0)
                    value+= dp[i-1][j];
                if(j-1>=0)
                    value+= dp[i][j-1];
                dp[i][j] = value;
            }
        }
        return dp[m-1][n-1];
    }
}