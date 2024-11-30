class Solution {
    public int coinsFind(int index, int amount, int[] coins, HashMap<String, Integer> memo) {
        if (index == 0) {
            if (amount % coins[0] == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        String currentState = index + " " + amount;
        if (memo.containsKey(currentState))
            return memo.get(currentState);
        int notTake = coinsFind(index - 1, amount, coins, memo);
        int take = 0;
        if (coins[index] <= amount) {
            take = coinsFind(index, amount - coins[index], coins, memo);
        }
        int result = take+notTake;
        memo.put(currentState, result);
        return result;
    }

    public int change(int amount, int[] coins) {
        HashMap<String,Integer>memo = new HashMap<>();
        int n = coins.length;
        int ans = coinsFind(n-1,amount,coins,memo);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}