import java.util.* ;
import java.io.*; 
public class Solution {
	public static int getLongestSubarray(int []nums, int k) {
		// Write your code here.
		HashMap<Long,Integer>map = new HashMap<>();
        int len = 0, maxLen = 0;
        long sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(sum==k) {
                len = i+1;
                maxLen = Math.max(len,maxLen);
            }
            else{
                long rem = sum-k;
                if(map.containsKey(rem)){
                    len = i-map.get(rem);
                    maxLen = Math.max(len,maxLen);
                }
            }
            if(!map.containsKey(sum))
            map.put(sum,i);
        }
        return maxLen;
	}
}