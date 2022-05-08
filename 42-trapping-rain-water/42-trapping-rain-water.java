class Solution {
    public static int trap(int[] height) {
        int n = height.length;
        if(n<3)return 0;
        int [] left = new int[n];
        int [] right = new int[n];
        left[1] = Math.max(height[0], height[1]);
        for (int i = 1; i < n-1; i++) {
            left[i+1] = Math.max(height[i], left[i]);
        }

        right[n-2] = Math.max(height[n-1], height[n-2]);
        for (int i = n-2; i > 0; i--) {
            right[i-1] = Math.max(height[i], right[i]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if(Math.min(left[i], right[i]) >= height[i]) ans += Math.min(left[i], right[i]) - height[i];
        }
        return ans;
    }
}