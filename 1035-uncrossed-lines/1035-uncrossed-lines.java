class Solution {
    public static int maxUncrossedLines(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;

        int [][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(nums1[i] == nums2[j]) dp[i][j] = ((i>=1 && j >= 1) ? dp[i-1][j-1] : 0) + 1;
                else dp[i][j] = Math.max((i >= 1) ? dp[i-1][j] : 0, (j >= 1) ? dp[i][j-1] : 0);
            }
        }
        return dp[n-1][m-1];
    }
}