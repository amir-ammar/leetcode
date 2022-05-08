class Solution {
    public boolean canPartition(int[] nums) {
        boolean [][] dp = new boolean[201][20001];
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {sum += nums[i];}
        if(sum % 2==1)return false;
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) { // number of element taken into consideration till now
            for (int j = 0; j <= sum/2; j++) { // target sums
                if(nums[i-1] <= j)dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][sum/2];
    }
}