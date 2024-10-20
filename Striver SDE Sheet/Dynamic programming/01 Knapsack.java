import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	public static int knapsack(ArrayList<Integer>values, ArrayList<Integer> weights,int index, int bagWeight,int[][]dp){
		if(index==0){
			if(bagWeight>=weights.get(0)){
				return values.get(0);
			}
			else
				return 0;
		}
		if(dp[index][bagWeight]!=-1) return dp[index][bagWeight];
		int notTake = knapsack(values, weights, index-1, bagWeight,dp);
		int take = 0;
		if(bagWeight>=weights.get(index)){
			take = knapsack(values, weights, index-1, bagWeight-weights.get(index),dp)+values.get(index);
		}
		return dp[index][bagWeight] = Math.max(take,notTake);
	}
	public static int maxProfit(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int w) {
		// Write your code here.
		int dp[][] =  new int[n][w+1];
		for(int[]row:dp){
			Arrays.fill(row, -1);
		}
		return knapsack(values, weights, n-1, w,dp);
	}
}