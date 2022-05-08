class Solution {
    public int countVowelStrings(int n) {
        int [][] dp = new int[n+1][5];
        dp[1][0] = 1;
        for (int i = 1; i < 5; i++) {
            dp[1][i] = 1 + dp[1][i-1];
        }
        for (int i = 2; i < n+1; i++) {
            dp[i][0] = dp[i-1][0];
            for (int j = 1; j < 5; j++) {
                dp[i][j] += dp[i-1][j] + dp[i][j-1] ;
            }
        }
        return dp[n][4];
    }
}