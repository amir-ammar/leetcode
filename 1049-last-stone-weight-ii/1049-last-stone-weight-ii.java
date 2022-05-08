class Solution {
    public static int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for (int x:stones) {
            sum += x;
        }
        boolean [] dp = new boolean[(sum/2)+1];
        int half = (sum/2)+1;
        dp[0] = true;
        for (int stone: stones) {
            boolean [] tmp = dp.clone();
            for(int j = stone; j < half; j++){
                if(dp[j - stone])tmp[j] = true;
            }
            dp = tmp;
        }
        int s = 0;
        for (int i = half-1; i >= 0; i--) {
            if(dp[i]){s=i;break;}
        }

        return sum-(2*s);

    }
}