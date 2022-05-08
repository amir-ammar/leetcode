class Solution {
    static int n;
    static int [] squares;
    static int [] memo;

    public static int dp(int i){
        if(i==0)return 0;
        if(memo[i]!=-1)return memo[i];
        int ans = Integer.MAX_VALUE;
        for (int j = (int)Math.sqrt(i); j >= 1; j--) {
            ans = Math.min(ans, 1 + dp(i - squares[j]));
        }
        return memo[i] = ans;
    }

    public int numSquares(int n) {
        squares = new int[101];
        memo = new int[n+1];
        for (int i = 1; i <= (int)Math.sqrt(n); i++) {
            squares[i] = i * i;
        }

        Arrays.fill(memo, -1);
        return dp(n);
    }
}