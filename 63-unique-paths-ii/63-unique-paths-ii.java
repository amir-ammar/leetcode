class Solution {
    static int [][]memo;
    public  int uniquePathsWithObstacles(int [][]obstacleGrid){
        
        memo = new int [obstacleGrid.length][obstacleGrid[0].length];
        return solve(0, 0, obstacleGrid);
    }

    public  int solve(int x, int y, int [][]obstacleGrid){
        
        if(x==obstacleGrid.length-1 && y==obstacleGrid[0].length-1){
            if(obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]==0 && obstacleGrid[0][0]!=1)
                return 1;
            else
                return 0;
        }
        if(memo[x][y]!=0)return memo[x][y];
        int tmp = 0;
        if(x<obstacleGrid.length-1 && obstacleGrid[x+1][y]!=1){
            tmp += solve(x+1, y, obstacleGrid);
        }

        if(y<obstacleGrid[x].length-1 && obstacleGrid[x][y+1]!=1){
            tmp += solve(x, y+1, obstacleGrid);
        }

        return memo[x][y] = tmp;

    }
}