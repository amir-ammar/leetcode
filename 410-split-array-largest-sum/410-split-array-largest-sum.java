class Solution {
    public static boolean check(int max, int m, int [] arr) {

        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (sum + arr[i] > max) {
                sum = arr[i];
                m--;
            } else {
                sum += arr[i];
            }
        }

        if (m - 1 >= 0) return true;
        else return false;
    }


    public static int splitArray(int[] nums, int m) {
        int n = nums.length;
        int max = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            sum += nums[i];
        }

        int l = max;
        int r = sum;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (check(mid, m, nums)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}