class Solution {
    static int n;
    static int m;

    public static int countSquares(int[][] matrix) {
        n = matrix.length;
        m = matrix[0].length;
        int [][] count = new int[n][m];
        for (int i = 0; i < m; i++) {
            count[0][i] = matrix[0][i];
        }
        for (int i = 0; i < n; i++) {
            count[i][0] = matrix[i][0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if(matrix[i][j]==1) count[i][j] = 1 + Math.min(count[i-1][j-1], Math.min(count[i-1][j], count[i][j-1]));
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sum += count[i][j];
            }
        }
        return sum;
    }
}