class Solution {
    public static boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int [][][] dp = new int[n][n][2];
        for (int i = 0; i < n; i++) {
           dp[i][i][0] = nums[i];
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= n-i; j++) {
                int first = j;
                int last = j+i-1;
                dp[first][last][0] = Math.max(nums[first] + dp[first+1][last][1], nums[last] + dp[first][last-1][1]);
                if(nums[first] + dp[first+1][last][1] > nums[last] + dp[first][last-1][1]){
                    dp[first][last][1] = dp[first+1][last][0];
                }else{
                    dp[first][last][1] = dp[first][last-1][0];
                }
            }
        }
        return dp[0][n-1][0] >= dp[0][n-1][1];
    }
}