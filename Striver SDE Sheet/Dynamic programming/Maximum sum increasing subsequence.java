class Solution
{
	public int MIS(int[] arr, int index, int prev, int[][] dp){
	    if(index==0){
	        if(prev==-1 || arr[index]<arr[prev]){
	            return arr[index];
	        }
	        else{
	            return 0;
	        }
	    }
	    if(dp[index][prev+1]!=-1) return dp[index][prev+1];
	    int notTake = MIS(arr, index-1, prev, dp);
	    int take = 0;
	    if(prev==-1 || arr[index]<arr[prev]){
	       take = MIS(arr, index-1, index, dp)+arr[index];
	    }
	    return dp[index][prev+1] = Math.max(take,notTake);
	}
	public int maxSumIS(int arr[], int n)  
	{  
	    //code here.
	    int dp[][] =  new int[n][n+1];
	    for(int[] row:dp){
	        Arrays.fill(row,-1);
	    }
	    return MIS(arr, n-1, -1, dp);
	}  
}