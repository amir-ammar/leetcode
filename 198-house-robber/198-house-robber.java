class Solution {
    public int rob(int[] nums) {
        int [] dp = new int[nums.length];
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            dp[i] = nums[i];
            int tmp = Integer.MIN_VALUE;
            for (int j = 0; j <= i-2; j++) {
                tmp = Math.max(tmp, dp[j]);
            }
            dp[i] += Math.max(tmp, 0);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}