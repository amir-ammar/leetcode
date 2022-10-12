class Solution {
    public static int findNumberOfLIS(int[] nums) {

        int [] ans = new int[nums.length];
        ans[0] = 1;
        int count = 0;
        int largest = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            int max = 0;
            for (int j = i-1; j >= 0; j--) {
                if (nums[i] > nums[j]) max = Math.max(max, ans[j]);
            }
            ans[i] = 1 + max;
            largest = Math.max(largest, ans[i]);
        }
        if (largest == 1 || nums.length == 1) return nums.length;
        int [] arr = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if(ans[i] == 1) arr[i] = 1;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i-1; j >= 0; j--) {
                if(ans[j] + 1 == ans[i] && nums[j] < nums[i]) arr[i] += arr[j];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (ans[i] == largest) count += arr[i];
        }

        return count;
    }
}