class Solution {
    public static int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        firstLen--;
        secondLen--;
        int n = nums.length;

        int [][] sum = new int[n][Math.max(firstLen, secondLen)+1];
        for (int i = 0; i < n; i++) {
            sum[i][0] = nums[i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= Math.min(i, Math.max(firstLen, secondLen)); j++) {
                sum[i][j] = nums[i] + sum[i-1][j-1];
            }
        }

        int [][] dp = new int[n][2];
        dp[firstLen][0] = sum[firstLen][firstLen];
        for (int i = firstLen+1; i < n; i++) {
            dp[i][0] = Math.max(sum[i][firstLen], dp[i-1][0]);
        }

        dp[secondLen][1] = sum[secondLen][secondLen];
        for (int i = secondLen+1; i < n; i++) {
            dp[i][1] = Math.max(sum[i][secondLen], dp[i-1][1]);
        }
        for (int [] x:dp) {
            System.out.println(Arrays.toString(x));
        }


        int max = Math.max(firstLen, secondLen);
        int min = Math.min(firstLen, secondLen);
        int ans = 0;
        for (int i = max; i < n; i++) {
            int tmp = 0;
            for (int j = i-max-1; j >= 0; j--) {
                tmp = Math.max(sum[j][min], tmp);
            }
            ans = Math.max(ans, sum[i][max]+tmp);
        }

        for (int i = min; i < n; i++) {
            int tmp = 0;
            for (int j = i-min-1; j >= 0; j--) {
                tmp = Math.max(sum[j][max], tmp);
            }
            ans = Math.max(ans, sum[i][min]+tmp);
        }
        return ans;
    }
}