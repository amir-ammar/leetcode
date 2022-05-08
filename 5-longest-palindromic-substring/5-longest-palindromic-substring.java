class Solution {
    public String longestPalindrome(String s) {
        int [][] memo = new int [s.length()][s.length()];

        for (int i = 0; i < memo.length; i++) {
            memo[i][i] = 1;
        }

        for(int i = 0 ; i<memo.length-1 ; i++){
            if(s.charAt(i)==s.charAt(i+1))
                memo[i][i+1] = 2;
        }

        for (int i = 3; i <= memo.length; i++) {
            for (int j = 0; j <= s.length()-i; j++) {
                if(s.charAt(j)==s.charAt(i+j-1) && memo[j+1][i+j-2]!=0){
                    memo[j][j+i-1] += memo[j+1][j+i-2]+2;
                }
            }
        }

        int x = 0;
        int y = 0;
        int max = 1;

        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo.length; j++) {
                if(max<memo[i][j]){
                    max = memo[i][j];
                    x = i;
                    y = j;
                }
            }
        }
        //System.out.println(Arrays.deepToString(memo));
        return s.substring(x, y+1);
    }
}