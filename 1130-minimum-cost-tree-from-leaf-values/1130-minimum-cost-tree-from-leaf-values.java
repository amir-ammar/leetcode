class Solution {
    static int [] arr;
    static int [][] memo;
    public static int mctFromLeafValues(int[] array) {
        int n = array.length;
        arr = array;
        memo = new int[n][n];
        for (int[]x:memo) {
            Arrays.fill(x, -1);
        }
        return dp(0,n-1);
    }
    public static int dp(int i, int j){
        if(i>=j)return 0;
        if(memo[i][j] != -1)return memo[i][j];
        int ans = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            ans = Math.min(ans, dp(i,k) + dp(k+1,j) + largest(i,k) * largest(k+1, j));
        }
        return memo[i][j] = ans;
    }

    public static int largest(int i, int j){
        int max = 0;
        for (int k = i; k <= j; k++) {
            max = Math.max(max, arr[k]);
        }
        return max;
    }
}