class Solution {
    public int uniquePaths(int n, int m){
        int [][] memo = new int[n][m];
        memo[n-1][m-1] = 1;

        for (int i = n-1; i >= 0; i--) {
            for(int j = m-1 ; j>=0 ; j--){
                if(i+1<n){
                    memo[i][j] += memo[i+1][j];
                }
                if(j+1<m){
                    memo[i][j] += memo[i][j+1];
                }
            }
        }

        
        return memo[0][0];
    }
    
}