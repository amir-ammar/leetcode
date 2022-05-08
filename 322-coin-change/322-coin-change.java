class Solution {
    static int [] coin;
    static int amount;
    static Integer [] memo;


    public static int dp(int amount){
        if(amount == 0) return 0;
        if(memo[amount] != null){return memo[amount];}
        int ans = (int)1e5;
        for (int i = 0; i < coin.length; i++) {
            if(amount >= coin[i]) ans = Math.min(ans, 1 + dp(amount - coin[i]));
        }
        return memo[amount] = ans;
    }
    public int coinChange(int[] coins, int amount) {
        coin = coins.clone();
        memo = new Integer[amount + 1];
        return dp(amount) > amount | dp(amount) < 0?-1:dp(amount);
    }
}