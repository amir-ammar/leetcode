class Solution {
    public static void moveZeroes(int[] nums) {
        int j = -1;
        int zeros = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (j == -1) j = i;
                zeros++;
            } else {
                if (zeros != 0) nums[j++] = nums[i];
            }
        }
        for (int i = nums.length-zeros; i < nums.length ; i++) {
            nums[i] = 0;
        }
    }
}