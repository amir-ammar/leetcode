class Solution {
    public static int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int rem = target - numbers[i];
            int l = 0;
            int r = numbers.length-1;
            int res = 0;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (numbers[mid] == rem) { res = mid; break; }
                else if (numbers[mid] > rem) {
                    r = mid-1;
                } else {
                    l = mid+1;
                }
            }
            if (res != i && rem == numbers[res]) {
                ans[0] = i+1;
                ans[1] = res+1;
                break;
            }
        }
        Arrays.sort(ans);
        return ans;
    }
}