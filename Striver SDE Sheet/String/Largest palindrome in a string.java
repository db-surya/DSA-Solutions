class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean dp[][] = new boolean[n][n];
        int start = 0;
        int maxLength = 1;
        //Filling for single numbers
        for(int i=0;i<n;i++)
        {
            dp[i][i]=true;
        }
        //Filling for two numbers
        for(int i=0;i<n-1;i++)
        {
            if(s.charAt(i)==s.charAt(i+1))
            {
                dp[i][i+1]=true;
                start = i;
                maxLength = 2;
            }
        }
        //Filling for 2 -> n gaps
        for(int k=2;k<n;k++)
        {
            for(int i=0;i<n-k;i++)
            {
                if(s.charAt(i)==s.charAt(i+k) && dp[i+1][i+k-1])
                {
                    dp[i][i+k]=true;
                    maxLength = k+1;
                    start = i;
                }
            }
        }
        return s.substring(start, start+maxLength);
    }
}