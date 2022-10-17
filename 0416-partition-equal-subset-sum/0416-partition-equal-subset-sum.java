class Solution {
    static Boolean [][] memo;
    public boolean helper(int i, int sum, int half, int [] nums) {
        if (i == nums.length) { return sum == half; }
        if (memo[i][sum] != null) return memo[i][sum];
        return memo[i][sum] = helper(i+1, sum + nums[i], half, nums) | helper(i+1, sum, half, nums);
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) return false;
        memo = new Boolean[nums.length][sum+1];
        return helper(0, 0, sum / 2, nums);
    }
}