class Solution
{
    public List<String> AllPossibleStrings(String s)
    {
        // Code here
        List<String>ans = new ArrayList<>();
        int N = s.length();
        int limit = (1<<N)-1;
        for(int i=1;i<=limit;i++){
            String str = "";
            for(int j=0;j<N;j++){
                if((i & (1<<j))!=0)
                str+=s.charAt(j);
            }
            ans.add(str);
        }
        Collections.sort(ans);
        return ans;
    }
}