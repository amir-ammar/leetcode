class Solution {
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        if(n==1)return true;
        int [] dp = new int[n];
        dp[0] = nums[0];
        dp[n-1] = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i-1]-1, nums[i-1]-1);
            if(dp[i]<0)return false;
        }

        return dp[n-1]>=0 ;
    }
}