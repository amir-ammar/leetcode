class Solution {
    static int rows;
    static int cols;

    public static boolean valid(int x, int y){
        return x >= 0 && x < rows &&y >= 0 && y < cols;
    }

    public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        rows = m;
        cols = n;
        int [][][] dp = new int[m][n][maxMove+1];
        int mod = (int)(1e9+7);
        int [] dx = new int[]{1,-1,0,0};
        int [] dy = new int[]{0,0,-1,1};

        for (int i = 1; i <= maxMove; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < 4; l++) {
                        int tmpx = j + dx[l];
                        int tmpy = k + dy[l];
                        if(valid(tmpx, tmpy)){
                            dp[j][k][i] = (dp[j][k][i] + dp[tmpx][tmpy][i-1]) % mod;
                        }else{
                            dp[j][k][i] = (dp[j][k][i] + 1) % mod;
                        }
                    }
                }
            }
        }
        return dp[startRow][startColumn][maxMove];
    }
}