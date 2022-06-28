class Solution {
    static class pair {
        int x;
        int y;

        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n;
    static int m;
    static boolean [][] visited;
    static Queue<pair> q;
    static int [] dx = {1, -1, 0, 0};
    static int [] dy = {0, 0, 1, -1};

    static int [][] grid;

    static boolean valid;

    // function to check if the given cell is valid or not
    static boolean isValid(int x, int y) {
        return (x >= 0 && x < n && y >= 0 && y < m);
    }


    public static void bfs(pair point, boolean pacific, boolean atlantic) {

        if (point.x == 0 || point.y == 0) pacific = true;
        if (point.x == visited.length - 1 || point.y == visited[0].length - 1) atlantic = true;
        if (pacific && atlantic) valid = true;

        for (int i = 0; i < 4; i++) {
            if (isValid(point.x + dx[i], point.y + dy[i]) &&
                    !visited[point.x + dx[i]][point.y + dy[i]] &&
                    grid[point.x + dx[i]][point.y + dy[i]] <= grid[point.x][point.y]){
                    q.add(new pair(point.x + dx[i], point.y + dy[i]));
                    visited[point.x + dx[i]][point.y + dy[i]] = true;
            }
        }

        if (!q.isEmpty()) {
            pair p = q.remove();
            bfs(p, pacific, atlantic);
        }
    }



    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        grid = heights;
        n = heights.length;
        m = heights[0].length;
        List<List<Integer>> ans = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                visited = new boolean[n][m];
                q = new ArrayDeque<>();
                valid = false;
                bfs(new pair(i, j), false, false);
                if (valid) {
                    ans.add(new ArrayList<>(Arrays.asList(i, j)));
                }

            }
        }
        return ans;
    }
}