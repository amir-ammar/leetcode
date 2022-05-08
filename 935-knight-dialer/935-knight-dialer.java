class Solution {
    static int size;
    public static boolean isValid(int x, int y){
        return x >= 0 && x < 4 && y >= 0 && y < 3;
    }

    public static int knightDialer(int n) {
        int mod = (int)1e9+7;
        size = n;
        int [] dx = new int[]{2,2,-2,-2,1,1,-1,-1};
        int [] dy = new int[]{1,-1,1,-1,2,-2,2,-2};
        int [][][] dp = new int[4][3][n+1];
        for (int i = 0; i <= n; i++) {
            dp[3][0][i] = -1;
            dp[3][2][i] = -1;
        }
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j][1] = 1;
            }
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 8; l++) {
                        int newx = j + dx[l];
                        int newy = k + dy[l];
                        if(isValid(newx, newy) && dp[newx][newy][i] != -1){
                            dp[j][k][i] = (dp[j][k][i] + dp[newx][newy][i-1]) % mod;
                        }
                    }

                }
            }
        }
        int ans = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if((i==3 && j==0) || (i==3 && j==2))continue;
                ans = (ans + dp[i][j][n]) % mod;
            }
        }
        return ans;
    }
}