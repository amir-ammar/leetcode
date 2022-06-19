class Solution {
    static class pair {
        int index, height;
        pair(int x, int y) {
            index = x;
            height = y;
        }
        public String toString(){
            return "index " + index + " height " + height;
        }
    }


    public static int largestRectangleArea(int[] heights) {


        int n = heights.length;
        Stack<pair> st = new Stack<>();
        int max = -1;
        for (int i = 0; i < n; i++) {

            int last = -1;
            while (!st.isEmpty() && st.peek().height >= heights[i]) {
                pair tmp = st.pop();
                int ind = tmp.index;
                int h = tmp.height;
                last = ind;
                max = Math.max(max, h * (i - ind));
            }
            st.add(new pair(last == -1 ? i : last, heights[i]));

        }

        while (!st.isEmpty()) {
            pair tmp = st.pop();
            int ind = tmp.index;
            int h = tmp.height;
            max = Math.max(max, h * (n - ind));
        }


        return max;
    }
}