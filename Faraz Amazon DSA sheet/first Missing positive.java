class Solution {
    public int firstMissingPositive(int[] nums) {
        int N =  nums.length;
        //Neutralizing the negatives
        for(int i=0;i<N;i++){
            if(nums[i]<0) nums[i] = 0;
        }
        //Marking the values as negatives
        for(int i=0;i<N;i++){
            int index = Math.abs(nums[i]);
            if(index-1>=0 && index-1<N){
                if(nums[index-1]==0) nums[index-1] = -(N+1);
                else nums[index-1] = -(Math.abs(nums[index-1]));
            }
        }
        //Iterating and find the number;
        int ans = N+1;
        for(int i=0;i<N;i++){
            if(nums[i]>=0){
                ans = i+1;
                break;
            }
        }
        return ans;
    }
}