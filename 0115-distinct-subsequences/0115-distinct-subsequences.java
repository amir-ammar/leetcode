class Solution {
    static int [][] memo;
    public static int solve (int i, int j, String s, String t) {
        if (j == t.length()) return 1;
        if (i == s.length()) return 0;
        if (memo[i][j] != -1) return memo[i][j];
        int ans = 0;
        if (s.charAt(i) == t.charAt(j)) {
            ans = solve(i+1, j+1, s, t);
        }
        ans += solve(i+1, j, s, t);
        return memo[i][j] = ans;
    }

    public static int numDistinct(String s, String t) {
        memo = new int[s.length()][t.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                memo[i][j] = -1;
            }
        }
        return solve(0, 0, s, t);
    }
}