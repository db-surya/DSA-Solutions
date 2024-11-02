class Solution {
    public boolean partition(int[] nums, int index, int target, Boolean[][] dp) {
        if (target == 0) return true;  // If target is zero, we've found a valid partition
        if (index < 0 || target < 0) return false;  // If target goes negative or no more elements, return false

        if (dp[index][target] != null) return dp[index][target];  // Use memoized result if available

        // Recursively check if we can partition by taking or not taking the current number
        boolean take = partition(nums, index - 1, target - nums[index], dp);
        boolean notTake = partition(nums, index - 1, target, dp);

        // Store and return the result
        return dp[index][target] = take || notTake;
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n : nums) sum += n;

        // If the total sum is odd, partitioning into two equal parts is impossible
        if (sum % 2 != 0) return false;

        int target = sum / 2;
        int n = nums.length;
        Boolean[][] dp = new Boolean[n][target + 1];  // Use Boolean array for memoization

        return partition(nums, n - 1, target, dp);
    }
}