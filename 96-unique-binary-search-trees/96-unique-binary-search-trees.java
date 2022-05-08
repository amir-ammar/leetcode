class Solution {
    static int memo[];

    public static int numTrees(int n) {
        memo = new int [n+1];
        Arrays.fill(memo, -1);
        return solve(n);
    }


    public static int solve(int n){
        if(n==0 || n==1)return 1;

        if(memo[n]!=-1)return memo[n];
        int tmp = 0;
        for (int i = 1; i <= n; i++) {
            tmp += solve(i-1) * solve(n-i);
        }
        return memo[n] = tmp;
    }
}