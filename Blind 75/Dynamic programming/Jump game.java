class Solution {
    public boolean canJump(int[] nums) {
        int goal = nums.length-1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]+i>=goal) goal = i;
        }
        return goal == 0;
    }
}

/* Reaching the last index is the goal
 * Start from last index and reach back
 * Check who can reach there and if finally zero becomes the goal we won
 * If zero is not goal we lost
 */

 //Striver solution
 //At every index find to which we can jump
 //If current index is not reched then return false

 class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;
        for(int i=0;i<nums.length;i++){
            if(max<i) return false;
            max = Math.max(max, nums[i]+i);
        }
        return true;
    }
}