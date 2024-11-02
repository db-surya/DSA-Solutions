class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int element1 =0,element2 =0;
        int count1 = 0, count2 =0;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            if(count1==0 && nums[i]!=element2)
            {
                element1 = nums[i];
                count1++;
            }
            else if(count2==0 && nums[i]!=element1)
            {
                element2 = nums[i];
                count2++;
            }
            else if(nums[i]==element1)
                count1++;
            else if(nums[i]==element2)
                count2++;
            else
            {
                count1--;
                count2--;
            }
        }
        List<Integer> ans = new ArrayList<>();
        count1=0;
        count2=0;
        int majority = (n/3)+1;
        for(int i=0;i<n;i++)
        {   
            if(nums[i]==element1)
            {
                count1++;
                if(count1==majority)
                    ans.add(element1);
            }
            else if(nums[i]==element2)
            {
                count2++;
                if(count2==majority)
                    ans.add(element2);
            }
        }
        return ans;
    }
}