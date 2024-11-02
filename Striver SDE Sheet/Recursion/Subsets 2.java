class Solution {
    public void func(int index, List<Integer>temp, List<List<Integer>>ans, int[] nums)
    {
        ans.add(new ArrayList<>(temp));
        for(int i=index;i<nums.length;i++)
        {
            if(i!=index && nums[i]==nums[i-1]) continue;
            //first level -> not really but easy to understand
            temp.add(nums[i]);
            func(i+1, temp,ans,nums);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>>ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        func(0,temp,ans,nums);
        return ans;
    }
}