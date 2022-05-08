class Solution {
    static int [][] grid;
    static int [][] memo;
    static int rows;
    static int cols;


    public static int dp(int x, int y){
        if(x >= rows || y >= cols)return 0;
        if(memo[x][y]!=-1)return memo[x][y];
        int ans = 0;
        int down = dp(x+1, y);
        int right = dp(x, y+1);
        int diag = dp(x+1, y+1);
        if (grid[x][y]==1){
            ans = 1 + Math.min(diag, Math.min(right, down));
        }

        return memo[x][y] = ans;
    }

    public int maximalSquare(char[][] matrix) {
        rows = matrix.length;
        cols = matrix[0].length;

        grid = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = matrix[i][j]=='0'?0:1;
            }
        }
        memo = new int[rows][cols];
        for (int [] x: memo) {
            Arrays.fill(x, -1);
        }
        dp(0,0);
        int ans = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                ans = Math.max(ans, memo[i][j]);
            }
        }
        
        return ans * ans;
    } 
}