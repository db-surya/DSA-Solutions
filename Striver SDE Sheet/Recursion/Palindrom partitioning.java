class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>>ans = new ArrayList<>();
        List<String> substrings = new ArrayList<>();
        func(s,0,substrings,ans);
        return ans;
    }
    public void func(String s, int index, List<String>substrings, List<List<String>>ans)
    {
        if(index == s.length())
        {
            ans.add(new ArrayList<>(substrings));
            return;
        }
        for(int i=index; i<s.length();++i)
        {
            if(isPalindrome(s,index,i))
            {
                substrings.add(s.substring(index,i+1));
                func(s,i+1,substrings,ans);
                substrings.remove(substrings.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s,int start,int end)
    {
        while(start<end)
        {
            if(s.charAt(start++) != s.charAt(end--))    
                return false;
        }
        return true;
    }
}