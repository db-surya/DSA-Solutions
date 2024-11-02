class Solution {
    public void nextPermutation(int[] nums) {
        int breakPoint = -1;
        int n = nums.length;
        for(int i=n-1;i>=1;i--)
        {
            if(nums[i]>nums[i-1])
            {
            breakPoint = i-1;
            break;
            }
        }
        for(int i=n-1;i>breakPoint && breakPoint!=-1;i--)
        {
            if(nums[i]>nums[breakPoint])
            {
                //swap
                int temp = nums[i];
                nums[i] = nums[breakPoint];
                nums[breakPoint]=temp;
                break;
            }
        }
        int left = breakPoint+1;
        int right = n-1;
        while(left<right)
        {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
    }
}