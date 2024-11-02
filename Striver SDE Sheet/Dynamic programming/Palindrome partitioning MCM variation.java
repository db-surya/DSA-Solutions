

//User function Template for Java

class Solution{
    static boolean isPalindrome(String str){
        char s[] = str.toCharArray();
        int i=0,j=s.length-1;
        while(i<j){
            if(s[i]!=s[j]) return false;
            i++;
            j--;
        }
        return true;
    }
    static int partition(String str,int index, int[] dp){
        if(index==str.length()) return 0;
        if(dp[index]!=-1) return dp[index];
        int count = Integer.MAX_VALUE;
        for(int j=index;j<str.length();j++){
            if(isPalindrome(str.substring(index,j+1))){
                int currCount = 1+partition(str,j+1,dp);
                count = Math.min(count, currCount);
            }
        }
        return dp[index] = count;
    }
    static int palindromicPartition(String str)
    {
        // code here
        int dp[] = new int[str.length()];
        Arrays.fill(dp,-1);
        return partition(str,0,dp)-1;
    }
}