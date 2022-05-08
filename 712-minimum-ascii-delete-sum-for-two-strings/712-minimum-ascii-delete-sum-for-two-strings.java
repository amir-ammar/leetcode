class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n = s1.length()+1;
        int m = s2.length()+1;
        char [] arr1 = s1.toCharArray();
        char [] arr2 = s2.toCharArray();

        int [][] dp = new int[n][m];
        for (int i = 1; i < n; i++) {
            dp[i][0] += dp[i-1][0] + (int) arr1[i-1];
        }
        for (int i = 1; i < m; i++) {
            dp[0][i] += dp[0][i-1] + (int) arr2[i-1];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if(arr1[i-1]==arr2[j-1]) dp[i][j] = dp[i-1][j-1];
                else{
                    dp[i][j] = Math.min(dp[i-1][j] + arr1[i-1], dp[i][j-1] + arr2[j-1]);
                }
            }
        }
        return dp[n-1][m-1];
    }
}