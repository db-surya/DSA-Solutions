class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int limit = (int)Math.pow(2,n);
        List<List<Integer>>ans = new ArrayList<>();
        for(int i=0;i<limit;i++){
            List<Integer>curr = new ArrayList<>();
            for(int j=0;j<n;j++){
                int index =  i&(1<<j);
                if(index!=0)
                curr.add(nums[j]);
            }
            ans.add(curr);
        }
        return ans;
    }
}