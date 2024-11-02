

class Solution 
{
    //Function to find minimum number of attempts needed in 
    //order to find the critical floor.
    static int eggDrop(int n, int k) 
	{
	    // Your code here
	    int dp[][] = new int [n+1][k+1];
	    for(int i=1;i<=n;i++) dp[i][1] = 1;
	    for(int j=1;j<=k;j++) dp[1][j] = j;
	    for(int i=2;i<=n;i++){
	        for(int j=2;j<=k;j++){
	            dp[i][j] = Integer.MAX_VALUE;
	            for(int x=1;x<=j;x++){
                    int res = 1 + Math.max(dp[i-1][x-1], dp[i][j-x]);
                    dp[i][j] = Math.min(dp[i][j], res);	            }
	        }
	    }
	    return dp[n][k];
	}
}