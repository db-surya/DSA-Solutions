class Solution {
    public void func(int index, int target, int[] candidates, List<Integer>temp, List<List<Integer>>ans)
    {
        if(target==0)
        {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=index;i<candidates.length;i++)
        {
            if(i!=index && candidates[i]==candidates[i-1])continue;
            if(candidates[i]>target)break;
            temp.add(candidates[i]);
            func(i+1, target-candidates[i],candidates,temp,ans);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>>ans = new ArrayList<>();
        List<Integer>temp = new ArrayList<>();
        func(0,target,candidates,temp,ans);
        return ans;   
    }
}