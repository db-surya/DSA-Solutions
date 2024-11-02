class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0;i<n;i++)
        {
            if(i>0 && nums[i-1]==nums[i]) continue;
            int j=i+1;
            while(j<n)
            {
                int k = j+1;
                int l = n-1;
                while(k<l)
                {
                    long sum = nums[i];
                    sum+= nums[j];
                    sum+= nums[k];
                    sum+= nums[l];
                    if(sum < target) k++;
                    else if(sum > target) l--;
                    else
                    {
                        List<Integer> temp = Arrays.asList(nums[i],nums[j],nums[k],nums[l]);
                        ans.add(temp);
                        k++;
                        l--;
                        while(k<l && nums[k]==nums[k-1]) k++;
                        while(k<l && nums[l]==nums[l+1]) l--;
                    }
                }
                j++;
                while(j<n && nums[j]==nums[j-1]) j++;
            }
        }
        return ans;
    }
}