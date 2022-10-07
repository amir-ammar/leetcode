class Solution {
    public int climbStairs(int n) {
        if (n == 1 || n == 2) return n;
        int l = 1;
        int right = 2;
        for (int i = 3; i <= n; i++) {
            int tmp = right;
            right += l;
            l = tmp;
        } 
        return right;
    }
}