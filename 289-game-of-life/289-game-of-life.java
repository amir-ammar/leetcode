class Solution {
    static int [] dx = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
    static int [] dy = new int[]{1, 0, -1, 1, -1, 1, 0, -1};

    public static boolean isValid(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

   // the first bit for the current state and the second bit for the next state (example: 01 current state: 1, next state:0)
    // so our state will be 00, 01, 10, 11

    public static void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int live = 0;
                for (int k = 0; k < 8; k++) {
                    if (isValid(i + dx[k], j + dy[k], board.length, board[0].length) && (board[i+dx[k]][j+dy[k]] & 1) == 1) live++;
                }
                if (board[i][j] == 0) {
                    if (live == 3) board[i][j] = 2;
                } else {
                    if (!(live == 2 || live == 3)) board[i][j] = 1;
                    else board[i][j] = 3;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = board[i][j] >> 1;
            }
        }
    }
}