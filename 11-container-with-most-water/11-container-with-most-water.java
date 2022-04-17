class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int l = 0;
        int r = n-1;
        int area = 0;
        while(l<r){
            int h = Math.min(height[l], height[r]);
            int w = r-l;
            area = Math.max(area, w*h);
            if(height[r] < height[l])r--;
            else l++;
        }
        return area;
    }
}