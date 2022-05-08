class Solution {
    static int [] arr;
    static int [][] memo;
    public static int dp(int i, int j){
        if(j-i==2)return arr[i]*arr[i+1]*arr[j];
        if(j-i<2)return 0;
        if(memo[i][j] != -1)return memo[i][j];
        int ans = Integer.MAX_VALUE;
        for (int k = i+1; k < j; k++) {
            ans = Math.min(ans, arr[i] * arr[j] * arr[k] + dp(i, k) + dp(k, j));
        }
        return memo[i][j] = ans;
    }
    public int minScoreTriangulation(int[] values) {
        arr = values;
        int n = arr.length;
        memo = new int[n][n];
        for (int [] x:memo) {
            Arrays.fill(x, -1);
        }
        return dp(0, n-1);
    }
}