class Solution {
    public static int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int [][] ans = new int[n][m];

        int max = (int)1e6;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] != 0) {
                    int up = ((i > 0) ? ans[i-1][j] : max);
                    int left = ((j > 0) ? ans[i][j-1] : max);
                    ans[i][j] = Math.min(up, left) + 1;
                }
            }
        }


        for (int i = n-1; i >= 0; i--) {
            for (int j = m-1; j >= 0; j--) {
                if (mat[i][j] != 0) {
                    int down = ((i < n-1) ? ans[i+1][j] : max);
                    int right = ((j < m-1) ? ans[i][j+1] : max);
                    ans[i][j] = Math.min(ans[i][j], Math.min(down, right) + 1);
                }
            }
        }


        return ans;
    }
}