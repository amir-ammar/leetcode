class Solution {
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        if(n==1)return true;
        int [] dp = new int[n];
        dp[0] = nums[0];
        dp[n-1] = Integer.MIN_VALUE;
        int max = nums[0]-1;
        for (int i = 1; i < n; i++) {
            if(max<0)return false;
            dp[i] = max;
            max = Math.max(max-1, nums[i]-1);
        }

        return dp[n-1]>=0 ;
    }
}