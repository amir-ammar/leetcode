class Solution {
    public static int integerBreak(int n) {
        if(n==2 || n==3)return n-1;
        int [] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i] ,j * dp[i-j]);
            }
        }
        return dp[n];
    }
}