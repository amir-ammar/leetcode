class Solution {
    public static int[] productExceptSelf(int[] nums) {
        int [] pref = new int[nums.length];
        int [] suff = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int last = nums.length - i - 1;
            pref[i] = (i == 0 ? 1 : pref[i-1]) * nums[i];
            suff[last] = nums[last] * (last == (nums.length - 1) ? 1 : suff[last + 1]);
        }
        int [] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            ans[i] = (i == 0 ? 1 : pref[i-1]) * ((i == nums.length-1)? 1 : suff[i+1]);
        }
        return ans;
    }
}