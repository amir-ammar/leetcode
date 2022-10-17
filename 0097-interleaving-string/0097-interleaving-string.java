class Solution {
    static Boolean [][] memo;
    public boolean helper(int i, int j, int k, String s1, String s2, String s3) {
        if (k == s3.length()) {
            return i == s1.length() && j == s2.length();
        }
        if (memo[i][j] != null) return memo[i][j];
        boolean ans = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) ans = helper(i + 1, j, k + 1, s1, s2, s3);
        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) ans |= helper(i, j+1, k+1, s1, s2, s3);
        if (i < s1.length() && j < s2.length() && s1.charAt(i) != s3.charAt(k) && s2.charAt(j) != s3.charAt(k)) return false;
        return memo[i][j] = ans;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        memo = new Boolean[s1.length() + 1][s2.length() + 1];
        return helper(0,0,0,s1,s2,s3);
    }
}