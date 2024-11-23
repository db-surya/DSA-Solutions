class Solution {
    public int jump(int[] nums) {
        int jumps = 0, left = 0, right = 0, n = nums.length;
        while(right<n-1){
            int farthest = 0;
            for(int i=left;i<=right;i++){
                farthest = Math.max(farthest, nums[i]+i);
            }
            left = right+1;
            right = farthest;
            jumps+=1;
        }
        return jumps;
    }
}

/*
 * Have a range 
 * From that range pick the farthest you can go with that and create another range
 * Repeat untill last
 * Every jump denotes a range
 * Return jumps
 */