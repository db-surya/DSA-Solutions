class Solution {
    public int houseRobber1(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        
        int dp[] = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(nums[i - 1] + dp[i - 2], dp[i - 1]);
        }
        
        return dp[nums.length];
    }

    public int rob(int[] nums) {
        // Edge cases
        if (nums.length == 1) return nums[0];
        
        // Calculate max rob amount by excluding first or last house
        int robExcludingLast = houseRobber1(Arrays.copyOfRange(nums, 0, nums.length - 1));
        int robExcludingFirst = houseRobber1(Arrays.copyOfRange(nums, 1, nums.length));
        
        return Math.max(robExcludingLast, robExcludingFirst);
    }
}