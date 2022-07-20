class Solution {
    
    
    static int [] dy = new int[]{-1,0,1};

    static int [][][] memo;


    static boolean valid(int y1, int y2, int m) {
        return y1 >= 0 && y1 < m && y2 >= 0 && y2 < m;
    }


    static int dp (int x, int y1, int y2, int [][] grid) {

       if (x == grid.length - 1) return 0;
       if (memo[x][y1][y2] != -1) {return memo[x][y1][y2];}
        int ans = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (y1 + dy[i] == y2 + dy[j]) {
                    if (valid(y1 + dy[i], y2 + dy[j],grid[0].length)) {
                        ans = Math.max(ans, grid[x + 1][y1 + dy[i]] + dp(x + 1, y1 + dy[i], y2 + dy[j], grid));
                    }
                } else {
                    if (valid(y1 + dy[i], y2 + dy[j],grid[0].length))
                        ans = Math.max(ans, grid[x + 1][y1 + dy[i]] + grid[x + 1][y2 + dy[j]] + dp(x + 1, y1 + dy[i], y2 + dy[j], grid));
                }

            }
        }
        return memo[x][y1][y2] = ans;
    }
    
    public static int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        memo = new int[n][m][m];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < m; k++) {
                for (int l = 0; l < m; l++) {
                    memo[i][k][l] = -1;
                }
            }
        }

        return dp(0, 0, m-1, grid) + grid[0][0] + grid[0][m-1];
    }
    
    
}