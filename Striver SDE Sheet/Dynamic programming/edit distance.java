class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int dp[][] = new int[m+1][n+1];
        
        // Edge cases: if one string is empty
        if(m == 0) return n;
        if(n == 0) return m;
        
        // Initializing base cases
        for(int i = 0; i <= m; i++) {
            dp[i][0] = i;  // Deleting all characters from word1 to match empty word2
        }
        for(int j = 0; j <= n; j++) {
            dp[0][j] = j;  // Inserting all characters into word1 to match word2
        }
        
        // Filling dp table
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                char c1 = word1.charAt(i-1);
                char c2 = word2.charAt(j-1);
                
                if(c1 == c2) {
                    // No edit needed, carry over the previous diagonal value
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    // Consider all three operations and take the minimum
                    dp[i][j] = Math.min(dp[i-1][j-1],  // Substitution
                                        Math.min(dp[i][j-1],  // Insertion
                                                 dp[i-1][j]   // Deletion
                                        )
                                ) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
