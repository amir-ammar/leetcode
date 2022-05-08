class Solution {
    static int [][] memo;
    static int n;
    public static int getMoneyAmount(int n) {
        memo = new int[n+1][n+1];
        for (int [] x:memo) {
            Arrays.fill(x, -1);
        }
        return dp(1, n);
    }

    public static int dp(int lo, int hi){
        if(hi <= lo) return 0;
        if(memo[lo][hi]!=-1)return memo[lo][hi];
        int ans = Integer.MAX_VALUE;
        for (int i = lo; i <= hi; i++) {
            ans = Math.min(i + Math.max(dp(lo, i-1), dp(i+1, hi)), ans);
        }
        return memo[lo][hi] = ans;
    }
}