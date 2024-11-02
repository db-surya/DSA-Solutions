class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum+=nums[i];
        }
        int actual_sum= (n*(n+1))/2;
        return actual_sum-sum;
    }
}