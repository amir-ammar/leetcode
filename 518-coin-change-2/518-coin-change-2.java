class Solution {
    static int [] coin;
    static int memo[][];
    public static int dp(int rem, int last){
        if(rem==0)return 1;
        if(rem<0)return 0;

        if(memo[rem][last]!=-1)return memo[rem][last];
        int ans = 0;
        for (int i = 0; i < coin.length; i++) {
            if(last<=i)
                ans+=dp(rem-coin[i], i);
        }
        return memo[rem][last] = ans;
    }
    public static int change(int amount, int[] coins){
        memo = new int[5001][301];
        coin = coins;
        for (int [] arr:
                memo) {
            Arrays.fill(arr, -1);
        }

        return dp(amount,0);
    }
}