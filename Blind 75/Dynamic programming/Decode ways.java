class Solution {
    public int numDecodings(String s) {
        int dp[]=new int[s.length()+1];
        dp[0]=1;
        char c;
        c=s.charAt(0);
        dp[1]=c=='0'?0:1;
        for(int i=2;i<=s.length();i++)
        {
            if(s.charAt(i-1)-'0'>0 && s.charAt(i-1)-'0'<10)
                dp[i]+=dp[i-1];
            int a=Integer.valueOf(s.substring(i-2,i));
            if(a>9 && a<=26)
                dp[i]+=dp[i-2];
        }
        return dp[s.length()];
        
    }
}