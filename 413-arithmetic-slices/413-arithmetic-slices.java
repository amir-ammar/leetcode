class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if(n<=2) return 0;
        int [][] dp = new int[n+1][n];
        for (int i = 1; i < n; i++) {
            dp[2][i] = nums[i] - nums[i-1];
        }
        int ans = 0;
        for (int i = 3; i <= n; i++) {
            for (int j = i-1; j < n; j++) {
                if(nums[j] - nums[j-1] == dp[i-1][j-1]){
                    ans++;
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Integer.MIN_VALUE;
                }

            }
        }
        return ans;
    }
}