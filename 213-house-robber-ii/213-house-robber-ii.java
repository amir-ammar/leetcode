class Solution {
   public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int [] dp = new int[nums.length];
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n-1; i++) {
            dp[i] = nums[i] + (((i - 2) >= 0)? Math.max(dp[i-2],
                    (((i - 3) >= 0) ? dp[i-3] : 0)): 0);
            ans = Math.max(ans, dp[i]);
        }
        dp = new int[n];
        for (int i = 1; i < n; i++) {
            dp[i] = nums[i] + (((i - 2) >= 0)? Math.max(dp[i-2],
                    (((i - 3) >= 0) ? dp[i-3] : 0)): 0);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}