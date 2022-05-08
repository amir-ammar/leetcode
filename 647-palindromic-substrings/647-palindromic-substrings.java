class Solution {
    public int countSubstrings(String s) {
        char [] arr = s.toCharArray();
        int n = arr.length;
        boolean [][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i < n-1; i++) {
            if(arr[i]==arr[i+1]) dp[i][i+1] = true;
        }
        for (int i = 3; i <= n; i++) {
            for (int j = 0; j <= n-i; j++) {
                int first = j;
                int last = i+j-1;
                dp[first][last] = arr[first]==arr[last] && dp[first+1][last-1];
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(dp[i][j])ans++;
            }
        }
        return ans;
    }
}