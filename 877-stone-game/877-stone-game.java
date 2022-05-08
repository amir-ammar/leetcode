class Solution {
    static int [] arr;
    static int [][] memo;
    public static int dp(int i, int j){
        if(i > j) return 0;
        if(memo[i][j] != -1) return memo[i][j];
        int left;
        int right;
        if(((j-i+1)/2) % 2 == 0){
            left = arr[i] + dp(i+1, j);
            right = arr[j] + dp(i, j-1);
        }else{
            left = dp(i+1, j);
            right = dp(i, j-1);
        }
        return memo[i][j] = Math.max(left, right);
    }

    public boolean stoneGame(int[] piles) {
        memo = new int[piles.length][piles.length];
        for (int [] x: memo) {
            Arrays.fill(x, -1);
        }
        arr = piles;
        int sum = 0;
        for (int x:piles) {sum+=x;}
        int ans = dp(0, piles.length-1);
        return ans > sum - ans;
    }
}