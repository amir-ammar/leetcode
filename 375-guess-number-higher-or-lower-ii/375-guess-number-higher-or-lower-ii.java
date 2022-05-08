class Solution {
    static int memo[][];
    static int n;

    public int getMoneyAmount(int m) {
        n = m;
        memo = new int[n+1][n+1];
        for (int [] x:memo) {
            Arrays.fill(x, -1);
        }
        return dp(1, n);
    }
    
    public static int dp(int s, int e){
        if(s >= e)return 0;
        if(memo[s][e] != -1)return memo[s][e];
        int ans = Integer.MAX_VALUE;
        for (int i = s ; i<= e ; i++){
            ans = Math.min(ans, i + Math.max(dp(s, i-1), dp(i+1, e)));
        }
        return memo[s][e] = ans;
    }

}