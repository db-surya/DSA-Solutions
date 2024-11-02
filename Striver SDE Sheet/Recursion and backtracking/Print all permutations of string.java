class Solution {
    public void swap(int a, int b,int[] nums)
    {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public void allPermutations(int index, int[] nums, List<List<Integer>>ans)
    {
        if(index==nums.length-1)
        {
            List<Integer> ds = new ArrayList<>();
            for(int i=0;i<nums.length;i++)
            {
                ds.add(nums[i]);
            }
            ans.add(new ArrayList<>(ds));
        }
        for(int i=index;i<nums.length;i++)
        {
            swap(index,i,nums);
            allPermutations(index+1, nums, ans);
            swap(index,i,nums);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        allPermutations(0,nums,ans);
        return ans;
    }
}