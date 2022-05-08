class Solution {
    static int [][] dp;
    static int m;
    static int [][] memo;
    public static int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int n = students[0].length;
        m = students.length;
        dp = new int[m][m];
        for (int i = 0; i < m; i++) { // students
            for (int j = 0; j < m; j++) { // mentors
                int tmp = 0;
                for (int k = 0; k < n; k++) {
                    tmp += (students[i][k]==mentors[j][k]?1:0);
                }
                dp[i][j] = tmp;
            }
        }
        memo = new int[m][(1<<m)+1];
        for (int [] x:memo) {
            Arrays.fill(x, -1);
        }

        return dp(0, 0);
    }

    public static int dp(int idx, int mask){
        if(idx==m)return 0;
        if(memo[idx][mask]!=-1)return memo[idx][mask];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            if((mask&(1<<i))==0) ans = Math.max(ans, dp[idx][i] + dp(idx+1, mask | (1<<i)));
        }
        return memo[idx][mask] = ans;
    }
}