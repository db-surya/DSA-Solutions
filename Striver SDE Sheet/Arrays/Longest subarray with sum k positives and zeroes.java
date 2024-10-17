public class Solution {
    public static int longestSubarrayWithSumK(int []a, long k) {
        // Write your code here
        int left = 0, right = 0, len = 0, maxLen = 0, n = a.length;
        long sum = 0;
        while(right<n){
            sum+= a[right++];
            while(sum>k && left<right){
                sum-= a[left++];
            }
            if(sum==k){
                len = right-left;
                maxLen = Math.max(maxLen,len);
            }
        }
        return maxLen;
    }
}