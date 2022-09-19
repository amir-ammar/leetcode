class Solution {
   public static int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int l = 0;
        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];
            if (sum >= target) {
                min = Math.min(min, i - l + 1);
                for (; l < i; l++) {
                    if (sum >= target) {
                        min = Math.min(min, i - l + 1);
                        sum -= nums[l];
                    }
                    else break;
                }
                if (sum >= target) {
                    min = Math.min(min, i - l + 1);
                }
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

}