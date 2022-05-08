class Solution {
    public  int maximumWealth(int[][] accounts) {
        int max = Integer.MIN_VALUE;
        int count = 0;
        for(int i = 0 ; i<accounts.length ; i++){
            for(int j = 0 ; j<accounts[0].length ; j++){
                count += accounts[i][j];
            }
            if(count>max){
                max = count;
            }
            count = 0;
        }
        return max;
    }
}