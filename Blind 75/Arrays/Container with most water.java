class Solution {
    public int maxArea(int[] height) {
        int maxVal = Integer.MIN_VALUE;
        int left=0,right=height.length-1;
        while(left<right)
        {
            int area = (right-left)*Math.min(height[left],height[right]);
            maxVal= Math.max(maxVal,area);
            if(height[left]<height[right])
                left++;
            else
                right--;
        }
        return maxVal;
    }
}