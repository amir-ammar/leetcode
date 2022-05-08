class Solution {
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int [] prefix = new int [n];
        prefix[0] = stones[0];
        for (int i = 1; i < n; i++) {
            prefix[i] += stones[i] + prefix[i-1];
        }
        int [][]dp = new int [n][n];
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < n-i+1; j++) {
                int f = j;
                int l = i+j-1;
                int left = prefix[l-1] - (f > 0 ? prefix[f-1]:0) - dp[f][l-1];
                int right = prefix[l] - prefix[f] - dp[f+1][l];
                dp[f][l] = Math.max(left, right);
            }
        }
        return dp[0][n-1];
    }
}