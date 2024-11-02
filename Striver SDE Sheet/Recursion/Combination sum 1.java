class Solution {
    public void func(int index, int target, int[] candidates, List<Integer>temp, List<List<Integer>>ans)
    {
        if(index==candidates.length)
        {
            if(target == 0)
                ans.add(new ArrayList<>(temp));
            return;
        }
        if(candidates[index]<=target)
        {
            temp.add(candidates[index]);
            func(index,target-candidates[index],candidates,temp,ans);
            temp.remove(temp.size()-1);
        }
        func(index+1,target,candidates,temp,ans);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>ans = new ArrayList<>();
        List<Integer>temp = new ArrayList<>();
        func(0,target,candidates,temp,ans);
        return ans;   
    }
}