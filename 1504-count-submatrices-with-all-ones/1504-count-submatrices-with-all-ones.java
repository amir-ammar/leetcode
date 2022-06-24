class Solution {
    public static int numSubmat(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int res = 0;

        for (int i = 0; i < n; i++) {

            int [] h = new int[m];
            Arrays.fill(h, 1);
            for (int j = i; j < n; j++) {
                for (int k = 0; k < m; k++) h[k] &= mat[j][k];
                res += helper(h);
            }
        }
        return res;
    }

    public static int helper(int [] arr) {
        int res = 0;
        int length = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 1) length += arr[i];
            else length = 0;
            res += length;
        }
        return res;
    }
}