class Solution {
    public static int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i] - difference, 0) + 1);
            ans = Math.max(ans, map.get(arr[i]));
        }
        return ans;
    }
}