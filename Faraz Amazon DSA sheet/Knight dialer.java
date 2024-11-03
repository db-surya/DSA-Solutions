class Solution {
    public int knightDialer(int n) {
        int MOD = 1_000_000_007;
        int[][]dp =  new int[n][10];
        int[][]moves = {
            {4, 6},    // from 0
            {6, 8},    // from 1
            {7, 9},    // from 2
            {4, 8},    // from 3
            {0, 3, 9}, // from 4
            {},        // 5 is not a valid starting point
            {0, 1, 7}, // from 6
            {2, 6},    // from 7
            {1, 3},    // from 8
            {2, 4}     // from 9
        }; 
        for(int j=0;j<10;j++){
            dp[0][j] = 1;
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<10;j++){
                for(int move:moves[j]){
                    dp[i][j] = (dp[i][j]+dp[i-1][move])%MOD;
                }
            }
        }
        int result = 0;
        for(int j=0;j<10;j++){
            result =  (result+dp[n-1][j])%MOD;
        }
        return result;
    }
}