class Solution {
    static long [] memo;

    public static long dp(int idx, int n, int [][] arr) {
        if (idx >= n) return 0;
        if (memo[idx] != -1) return memo[idx];
        return memo[idx] = Math.max(arr[idx][0] + dp(idx + 1 + arr[idx][1], n, arr), dp(idx + 1, n, arr));
    }


    public static long mostPoints(int[][] questions) {

        int n = questions.length;
        memo = new long[n];
        Arrays.fill(memo, -1);
        return dp(0, n, questions);
    }
}