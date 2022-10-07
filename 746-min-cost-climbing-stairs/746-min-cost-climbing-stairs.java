class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length + 1;
        int l = cost[0];
        int r = cost[1];
        for (int i = 2; i < n; i++){
            int tmp = r;
            r = Math.min(r, l) + (i + 1 == n ? 0 : cost[i]);
            l = tmp;
        }
        return r;
    }
}