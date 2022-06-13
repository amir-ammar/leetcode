class Solution {
    static Integer[][] memo;

    public static int minSessions(int[] tasks, int sessionTime) {
        int n = tasks.length;
        memo = new Integer[1<<14][sessionTime];
        return dp(tasks, (1<<n) - 1, 0, sessionTime);
    }

    public static int dp(int [] tasks, int mask, int remainTime, int sessionTime){
        if (mask == 0) return 0;
        if(memo[mask][remainTime] != null) return memo[mask][remainTime];
        int ans = tasks.length;
        for (int i = 0; i < tasks.length; i++) {
            if(((mask >> i) & 1) == 1) {
                int newMask = (~(1 << i) & mask);
                if(tasks[i] <= remainTime) {
                    ans = Math.min(ans, dp(tasks, newMask, remainTime - tasks[i], sessionTime));
                } else {
                    ans = Math.min(ans,1 + dp(tasks, newMask, sessionTime - tasks[i], sessionTime));
                }
            }
        }
        return memo[mask][remainTime] = ans;
    }
}