class Solution {
    public int majorityElement(int[] nums) {
        int count=0,element=0;
        for(int i=0;i<nums.length;i++)
        {
           if(nums[i]==element)
           {
               count++;
           }
           else
           {
               if(count==0)
               {
                   element = nums[i];
                   count++;
               }
               else
               count--;
           }
        }
        return element;
    }
}