class Solution {
    static int [] dx = {0, 1, 0, -1};
    static int [] dy = {1, 0, -1, 0};

    static class pair {
        int x, y;
        pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        // toString() method to print the pair
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }


    public static boolean isValid(int x, int y, int n, int m){
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (helper(i, j, board, word, 0)) return true;
            }
        }
        return false;
    }

    public static boolean helper(int x, int y, char [][] board, String word, int i) {
        if (i == word.length()) return true;
        if (!isValid(x, y, board.length, board[0].length) || board[x][y] != word.charAt(i)) return false;

        boolean res = false;
        for (int j = 0; j < 4; j++) {
            char c = board[x][y];
            board[x][y] = '.';
            res |= helper(x + dx[j], y + dy[j], board, word, i + 1);
            board[x][y] = c;
        }
        return res;
    }
}