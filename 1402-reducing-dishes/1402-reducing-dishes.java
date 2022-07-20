class Solution {
    static int n;
    static int [][] memo;
    public static int dp (int i, int last, int [] arr) {
        if (i == n) return 0;
        if (memo[i][last] != -1) {return memo[i][last];}
        return memo[i][last] = Math.max(dp(i+1, last, arr), (last * arr[i]) + dp(i+1, last + 1, arr));
    }


    public static int maxSatisfaction(int[] satisfaction) {
        n = satisfaction.length;
        memo = new int[n][5001];
        for (int [] x:memo) {
            Arrays.fill(x, -1);
        }
        Arrays.sort(satisfaction);
        return dp(0, 1, satisfaction);
    }
}