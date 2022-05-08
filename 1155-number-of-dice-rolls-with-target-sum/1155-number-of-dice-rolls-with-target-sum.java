class Solution {
    public static int numRollsToTarget(int n, int k, int target) {
        long mod = (long)(1e9+7);
        int [][] dp = new int[n+1][target + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                for (int l = 1; l <= Math.min(target, k); l++) {
                    if(j>=l)dp[i][j] = (int) ((dp[i][j] + dp[i-1][j-l]) % mod);
                }
            }
        }

        return (int)(dp[n][target] % mod);
    }
}