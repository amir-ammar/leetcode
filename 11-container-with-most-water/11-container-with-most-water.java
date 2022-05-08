class Solution {
    public static int maxArea(int[] height) {
        int max = 0;
        
        int l = 0;
        int r = height.length-1;
        while (l<r){
            int w = r-l;
            int h = Math.min(height[r], height[l]);
            if(w*h>max){
                max = w*h;
            }else{
                if(height[r] < height[l])r--;
                else l++;
            }
        }
        return max;
    }
}