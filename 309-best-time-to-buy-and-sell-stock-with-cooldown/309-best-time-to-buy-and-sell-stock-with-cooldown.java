class Solution {
    static int [][] memo;
    static int n;
    static int [] profit;
    public static int dp(int idx, int state){
        if(idx >= n)return 0;
        if(memo[idx][state] != -1)return memo[idx][state];
        int ans = Integer.MIN_VALUE;
        if(state==0){ // state 0 -> you can buy or cool down
            ans = Math.max(dp(idx+1, 1) - profit[idx], dp(idx+1, 0));
        }
        else if(state==1){ // state 1 -> you can sell or coll down
            ans = Math.max(dp(idx+2, 0) + profit[idx], dp(idx+1, 1));
        }
        return memo[idx][state] = ans;
    }

    public static int maxProfit(int[] prices) {
        n = prices.length;
        memo = new int[n][2];
        profit = prices;
        for (int [] x: memo) {
            Arrays.fill(x, -1);
        }

        int ans = dp(0, 0);
        return Math.max(ans, 0);
    }
}