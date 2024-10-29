class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0,profit=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[buy]){
                profit+= prices[i]-prices[buy];
                buy = i;
            }else if(prices[i]<prices[buy]){
                buy = i;
            }
        }
        return profit;
    }
}