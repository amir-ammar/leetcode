class Solution {
    public static int dp(int i, int [][] mat, Integer [][] dp, int total, int target) {
        if (i == mat.length) return Math.abs(total - target);

        if(dp[i][total] != null) return dp[i][total];

        int res = Integer.MAX_VALUE;
        for(int j = 0; j < mat[0].length; j++){
            res = Math.min(res, dp(i + 1, mat, dp, total + mat[i][j], target));
        }
        return dp[i][total] = res;
    }

    public static int minimizeTheDifference(int[][] mat, int target) {
        int n = mat.length;
        int m = mat[0].length;
        Integer [][] dp = new Integer[71][71 * 71];
        return dp(0, mat, dp, 0, target);
    }
}