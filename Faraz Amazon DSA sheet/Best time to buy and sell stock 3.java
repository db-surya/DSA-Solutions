
//Tabulation code
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n + 1][2][3];

        // Initialize the base case where dp[n][buy][cap] = 0
        for (int buy = 0; buy <= 1; buy++) {
            for (int cap = 0; cap <= 2; cap++) {
                dp[n][buy][cap] = 0;
            }
        }

        // Fill the DP table in reverse order
        for (int index = n - 1; index >= 0; index--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= 2; cap++) {
                    if (buy == 1) {
                        int option1 = -prices[index] + dp[index + 1][0][cap];
                        int option2 = 0 + dp[index + 1][1][cap];
                        dp[index][buy][cap] = Math.max(option1, option2);
                    } else {
                        int option1 = prices[index] + dp[index + 1][1][cap - 1];
                        int option2 = 0 + dp[index + 1][0][cap];
                        dp[index][buy][cap] = Math.max(option1, option2);
                    }
                }
            }
        }

        return dp[0][1][2];
    }
}


//Recursion code

class Solution {
    public int bestTime(int index, int buy, int cap, int[] prices,int[][][] dp){
        if(cap==0) return 0;
        if(index == prices.length) return 0;
        if(dp[index][buy][cap]!=-1) return dp[index][buy][cap];
        if(buy==1){
            int option1 =  -prices[index]+bestTime(index+1,0,cap,prices,dp);
            int option2 =  0+bestTime(index+1,1,cap,prices,dp);
            return dp[index][buy][cap] = Math.max(option1,option2);
        }else{
            int option1 = prices[index]+bestTime(index+1,1,cap-1,prices,dp);
            int option2 =  0+bestTime(index+1,0,cap,prices,dp);
            return dp[index][buy][cap] = Math.max(option1,option2);
        }
    }
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length][2][3];
        for(int i=0;i<prices.length;i++){
            for(int j=0;j<=1;j++){
                for(int k=0;k<=2;k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return bestTime(0, 1, 2, prices,dp);
    }
}