class Solution {
    
    public static long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long even = nums[0];
        long odd = 0;
        for (int i = 1; i < n; i++) {
            even = Math.max(even, Math.max(odd + nums[i], nums[i]));
            odd = Math.max(odd, Math.max(even - nums[i], 0));
        }

        return Math.max(even, odd);
    }
}