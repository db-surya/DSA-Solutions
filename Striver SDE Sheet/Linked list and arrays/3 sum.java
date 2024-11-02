class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n=nums.length;
        for(int i=0;i<n-1;i++)
        {
            if(i>0 && nums[i-1]==nums[i]) continue;
            int j=i+1;
            int k=n-1;
            while(j<k)
            {
                int sum = nums[i]+nums[j]+nums[k];
                if(sum<0)
                    j++;
                else if(sum >0)
                    k--;
                else
                {
                    List<Integer> pair = new ArrayList<>();
                    pair.addAll(Arrays.asList(nums[i],nums[j],nums[k]));
                    ans.add(pair);
                    j++;
                    k--;
                    while(j<k && nums[j-1]==nums[j])j++;
                    while(j<k && nums[k+1]==nums[k])k--;
                }
            }
        }
        return ans;
    }
}