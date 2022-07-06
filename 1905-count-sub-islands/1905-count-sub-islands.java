class Solution {
    static class point {
        int x, y;
        point(int a, int b) {x = a; y = b;}

        // toString() method to print the point
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }

    static int [] dx = new int[]{0,1,0,-1};
    static int [] dy = new int[]{1,0,-1,0};

    public static boolean valid (int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static boolean check (ArrayList<point> arr, int [][] grid) {

        for (int i = 0; i < arr.size(); i++) {
            point cur = arr.get(i);
            if(grid[cur.x][cur.y] != 1) return false;
        }
        return true;
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {

        int n = grid2.length;
        int m = grid2[0].length;

        boolean [][] visited = new boolean[n][m];
        int ans = 0;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                if(grid2[i][j] == 1 && !visited[i][j]) {

                    ArrayList<point> island = new ArrayList<>();
                    island.add(new point(i, j));
                    Queue<point> q = new ArrayDeque<>();
                    q.add(new point(i, j));
                    visited[i][j] = true;
                    while (!q.isEmpty()) {

                        point cur = q.poll();
                        for (int k = 0; k < 4; k++) {

                            int newx = cur.x + dx[k];
                            int newy = cur.y + dy[k];

                            if (valid(newx, newy, n, m) && !visited[newx][newy] && grid2[newx][newy] == 1) {
                                island.add(new point(newx, newy));
                                q.add(new point(newx, newy));
                                visited[newx][newy] = true;
                            }
                            
                        }

                    }
                    System.out.println(island);
                    ans += check(island, grid1) ? 1 : 0;
                }


            }

        }
        return ans;
    }
}