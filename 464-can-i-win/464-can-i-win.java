class Solution {
    static int [][] memo;

    public static int dp(int sum, int player, int mask, int target, int limit){
        if(memo[player][mask] != -1) return memo[player][mask];
        else{
            for (int i = 1; i <= limit; i++) {
                if(((1<<(i-1)) & mask) ==0){
                    if(sum+i>=target ||
                       dp(sum+i, 1-player, mask | (1<<(i-1)), target, limit) != 1) // we need to return 1 to this state in case we can reach the target of even prevent the other player from reaching the target
                        return memo[player][mask] = 1;
                }
            }
        }
        return memo[player][mask] = 0;
    }
    public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal)return false; // in case the desiredTotal can not be reached even if we add all the number in the range
        memo = new int[2][1<<21];
        for (int [] x:memo) {
            Arrays.fill(x, -1);
        }
        return dp(0, 0, 0, desiredTotal, maxChoosableInteger) == 1;
    }
}