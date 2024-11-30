class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for(int a=1;a<=amount;a++){
            for(int coin:coins){
                if(a-coin>=0)
                    dp[a]=Math.min(dp[a],1+dp[a-coin]);
            }
        }
        return dp[amount]==amount+1?-1:dp[amount];
    }
}

//More intuitive method
class Solution {
    public int coinsFind(int index, int amount, int[] coins, HashMap<String,Integer>memo){
        if(index==0){
            if(amount%coins[0]==0){
                return amount/coins[0];
            }else{
                return Integer.MAX_VALUE;
            }
        }
        String currentState = index+" "+amount;
        if(memo.containsKey(currentState)) 
            return memo.get(currentState);
        int notTake = coinsFind(index-1,amount,coins,memo);
        int take = Integer.MAX_VALUE; 
        if(coins[index]<=amount){
            int takeResult = coinsFind(index,amount-coins[index],coins,memo);
            if(takeResult!=Integer.MAX_VALUE) take = 1+takeResult;
        }
        int result =  Math.min(take,notTake);
        memo.put(currentState,result);
        return result;
    }
    public int coinChange(int[] coins, int amount) {
        HashMap<String,Integer>memo = new HashMap<>();
        int n = coins.length;
        int ans = coinsFind(n-1,amount,coins,memo);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}