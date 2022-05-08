class Solution {
    static int memo[][];
    public static int minPathSum(int [][] grid){
        memo = new int[grid.length][grid[0].length];
        for (int[] is : memo) {
            Arrays.fill(is, Integer.MAX_VALUE);
        }
        return solve(0, 0, grid);
    }

    public static int solve(int x, int y, int [][]grid){
        if(x==grid.length-1 && y==grid[0].length-1){

            return grid[grid.length-1][grid[0].length-1];
        }
        if(memo[x][y]!=Integer.MAX_VALUE)return memo[x][y];
        int tmp = Integer.MAX_VALUE;
        if(x<grid.length-1){
            tmp = Math.min(tmp, grid[x][y]+solve(x+1, y, grid));
        }

        if(y<grid[0].length-1){
            tmp = Math.min(tmp, grid[x][y]+solve(x, y+1, grid));
        }

        return memo[x][y] = tmp;
    }
}