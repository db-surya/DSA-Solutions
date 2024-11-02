class Solution {
    public int LIS(int index, int prevIndex, int[] nums, int[][]dp, int N){
        if(index == N) return 0;
        if(dp[index][prevIndex+1]!=-1) return dp[index][prevIndex+1];
        int len = 0+LIS(index+1,prevIndex,nums,dp,N);
        if(prevIndex==-1 || nums[index]>nums[prevIndex])
            len = Math.max(len,1+LIS(index+1,index,nums,dp,N));
        return dp[index][prevIndex+1] = len;
    }
    public int lengthOfLIS(int[] nums) {
        int N = nums.length;
        int dp[][] = new int[N][N+1];
        for(int row[] : dp){
            Arrays.fill(row,-1);
        }
        int ans = LIS(0,-1,nums,dp,N);
        return ans;
    }
}