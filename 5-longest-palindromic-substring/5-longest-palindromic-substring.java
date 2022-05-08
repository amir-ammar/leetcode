class Solution {
    public String longestPalindrome(String s) {
        int [][] memo = new int [s.length()][s.length()];

        int max = 1;
        // palandrome SubString with one letter
        for (int i = 0; i < memo[0].length; i++) {
            memo[i][i] = 1;
        }

        int x = 0;
        int y = 0;
        // palandrome SubString with two letter 
        for (int i = 0; i < memo.length-1; i++) {
            if(s.charAt(i)==s.charAt(i+1)){
                memo[i][i+1] = 2;
            }   
        }
        
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < i; j++) {
                if(memo[j+1][i-1]!=0 && s.charAt(i)==s.charAt(j)){
                    memo[j][i] += memo[j+1][i-1]+2;
                }
            }
        }
        
        for (int i = memo.length-1; i >= 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if(max<memo[j][i]){
                    max = memo[j][i];
                    x = j;
                    y = i;
                }
            }
        }

        
        return s.substring(x, y+1);
    }
}