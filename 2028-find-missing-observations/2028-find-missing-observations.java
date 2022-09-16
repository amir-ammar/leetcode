class Solution {
    public static int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int total = mean*(n+m);

        for (int i = 0; i < rolls.length; i++) {
            total -= rolls[i];
        }
        int [] ans = new int[n];
        double tmp = (double) total / n;
        if (tmp > 6 || ((total/n) < 1 || (total/n) > 6)) return new int[]{};
        Arrays.fill(ans, total/n);
        total %= n;
        for (int i = 0; i < total; i++) {
            ans[i]++;
        }
        return ans;
    }
}