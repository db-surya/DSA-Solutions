class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)return "";
        String firstString = strs[0];
        if(strs.length == 1)
            return firstString;
        for(int i=0;i<firstString.length();i++)
        {
            for(int index = 1; index<strs.length; index++)
            {
                if(i < strs[index].length() 
                && firstString.charAt(i) == strs[index].charAt(i))
                {
                    continue;
                }
                else
                    return firstString.substring(0,i);
            }
        }
        return firstString;
    }
}