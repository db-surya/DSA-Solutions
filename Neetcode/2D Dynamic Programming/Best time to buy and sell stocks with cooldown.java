class Solution {
    public int bestTime(int index, boolean buy, int[] prices,HashMap<String,Integer>memo){
        if(index>=prices.length)
            return 0;
        String currentState = index+" "+buy;
        if(memo.containsKey(currentState))
            return memo.get(currentState);
        if(buy){
            int ans = Math.max(-prices[index]+bestTime(index+1,false,prices,memo),
            0+bestTime(index+1,buy,prices,memo));
            memo.put(currentState,ans);
            return ans;
        }
        int ans = Math.max(prices[index]+bestTime(index+2, true, prices,memo), 
        0+bestTime(index+1,buy,prices,memo));
        memo.put(currentState,ans);
        return ans;
    }
    public int maxProfit(int[] prices) {
        HashMap<String,Integer>memo = new HashMap<>();
        return bestTime(0, true, prices, memo);
    }
}