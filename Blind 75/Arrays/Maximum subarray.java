class Solution {
    public int maxSubArray(int[] nums) {
        int globalMax =  nums[0];
        int currSum = nums[0];
        for(int i=1;i<nums.length;i++)
        {   
            if(nums[i]>nums[i]+currSum)
            {
                currSum = nums[i];
            }
            else
            {
                currSum += nums[i];
            }
            globalMax = Math.max(currSum,globalMax);
        }
        return globalMax;
    }
}