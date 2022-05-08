class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        int [][][] dp = new int[n][2][2]; 
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(rating[i]>rating[j])dp[i][0][1]++;
                if(rating[i]<rating[j])dp[i][0][0]++;
            }
        }


        for (int i = 2; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(rating[i]>rating[j])dp[i][1][1] += dp[j][0][1];
                if(rating[i]<rating[j])dp[i][1][0] += dp[j][0][0];
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += dp[i][1][0] + dp[i][1][1];
        }
       return ans;
    }
}