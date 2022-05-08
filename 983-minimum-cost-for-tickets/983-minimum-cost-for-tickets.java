class Solution {
    static HashSet<Integer> hash;
    static int [] cost;
    static Integer [] memo;
    public static int dp(int i) {
        if(i>365)return 0;

        if(memo[i]!=null)return memo[i];
        int tmp = Integer.MAX_VALUE;

        if(hash.contains(i)){
            tmp = Math.min(cost[0]+dp(i+1),
                    Math.min(cost[1]+dp(i+7), cost[2]+dp(i+30)));
        }else tmp = dp(i+1);
        return memo[i] = tmp;
    }

    public static int mincostTickets(int[] days, int[] costs) {
        costs = costs;
        memo = new Integer[366];
        hash = new HashSet<>();
        cost = new int[costs.length];
        int cnt = 0;
        for (int z:costs) {
            cost[cnt] = costs[cnt++];
        }
        for (int d: days) hash.add(d);

        return dp(1);
    }
}