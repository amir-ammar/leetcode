class Solution {
    public static int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) set.remove(nums[i]);
            else set.add(nums[i]);
        }
        int ans = 0;
        for (int ele: set) ans = ele;
        return ans;
    }
}