class Solution {
    
    
    static int [] dx = new int[]{1,1,1};
    static int [] dy = new int[]{-1,0,1};

    static int [][][][] memo;


    static boolean valid(int i, int j, int x, int y) {
        return i >= 0 && i < x && j >= 0 && j < y;
    }


    static int dp (int x1, int y1, int x2, int y2, int [][] grid) {

       if (x1 == grid.length) return 0;
       if (memo[x1][y1][x2][y2] != -1) {return memo[x1][y1][x2][y2];}
        int ans = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (x1 + dx[i] == x2 + dx[j] && y1 + dy[i] == y2 + dy[j]) {
                    if (valid(x1 + dx[i], y1 + dy[i], grid.length, grid[0].length) &&
                            valid(x2 + dx[j], y2 + dy[j], grid.length, grid[0].length)) {
                        ans = Math.max(ans, grid[x1 + dx[i]][y1 + dy[i]] + dp(x1 + dx[i], y1 + dy[i], x2 + dx[j], y2 + dy[j], grid));
                    }
                } else {
                    if (valid(x1 + dx[i], y1 + dy[i], grid.length, grid[0].length) &&
                            valid(x2 + dx[j], y2 + dy[j], grid.length, grid[0].length))
                        ans = Math.max(ans, grid[x1 + dx[i]][y1 + dy[i]] + grid[x2 + dx[j]][y2 + dy[j]] + dp(x1 + dx[i], y1 + dy[i], x2 + dx[j], y2 + dy[j], grid));
                }

            }
        }
        return memo[x1][y1][x2][y2] = ans;
    }





    public static int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        memo = new int[n][m][n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < m; l++) {
                        memo[i][j][k][l] = -1;
                    }
                }
            }
        }

        return dp(0, 0, 0, m - 1, grid) + grid[0][0] + grid[0][m-1];
    }
    
    
}