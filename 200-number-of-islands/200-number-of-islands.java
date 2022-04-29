class Solution {
    public static int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        boolean [][] arr = new boolean[n][m];
        Queue<Integer> qx = new ArrayDeque<>();
        Queue<Integer> qy = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if(grid[i][j] == '1' && !arr[i][j]){
                    ans++;
                    qx.add(i);
                    qy.add(j);

                    while (!qx.isEmpty()){

                        int curX = qx.poll();
                        int curY = qy.poll();

                        arr[curX][curY] = true;

                        if(curX-1>=0 && grid[curX-1][curY] == '1' && !arr[curX-1][curY])
                        {
                            qx.add(curX-1);
                            qy.add(curY);
                            arr[curX-1][curY] = true;
                        }

                        if(curX+1 < n && grid[curX+1][curY] == '1'&& !arr[curX+1][curY])
                        {
                            qx.add(curX+1);
                            qy.add(curY);
                            arr[curX+1][curY] = true;
                        }

                        if(curY-1>=0 && grid[curX][curY-1] == '1'&& !arr[curX][curY-1])
                        {
                            qx.add(curX);
                            qy.add(curY-1);
                            arr[curX][curY-1] = true;
                        }

                        if(curY+1<m && grid[curX][curY+1] == '1'&& !arr[curX][curY+1])
                        {
                            qx.add(curX);
                            qy.add(curY+1);
                            arr[curX][curY+1] = true;
                        }
                    }
                }


            }
        }

        return ans;
    }
}