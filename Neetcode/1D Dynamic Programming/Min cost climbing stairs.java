class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        for(int i=2;i<n;i++){
            cost[i] = Math.min(cost[i-1],cost[i-2])+cost[i];
        }
        return Math.min(cost[n-1],cost[n-2]);
    }
}