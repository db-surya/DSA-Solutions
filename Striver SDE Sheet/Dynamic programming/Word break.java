class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int N = s.length();
        boolean dp[] = new boolean[N+1];
        dp[N] = true;
        for(int i=N-1;i>=0;i--){
            for(int j=0;j<wordDict.size();j++){
                String dictWord = wordDict.get(j);
                int len = dictWord.length();
                System.out.println(i+dictWord.length());
                if(i+dictWord.length()<=N && s.substring(i,i+len).equals(dictWord)){
                    dp[i] = dp[i+len];
                }
                if(dp[i]) break;
            }
        }
        return dp[0];
    }
}