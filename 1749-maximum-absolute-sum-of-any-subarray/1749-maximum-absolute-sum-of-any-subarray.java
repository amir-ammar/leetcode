class Solution {
    public static int abs(int x){
        return Math.abs(x);
    }
    public static int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int max = 0;
        int x = 0, y = 0;

        for (int i = 0; i < n; i++) {
            x += nums[i];
            y += nums[i];
            max = Math.max(max, Math.max(x, abs(y)));
            if(x < 0){
                x = 0;
            }
            if(y > 0){
                y = 0;
            }
        }
        return max;
    }
}