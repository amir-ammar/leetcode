class Solution {
    static class pair implements Comparable<pair>{
        int x, y;
        pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public int compareTo(pair o){
            return Math.abs(x - y) - Math.abs(o.x - o.y);
        }
    }

    public int twoCitySchedCost(int[][] costs) {
        pair [] arr = new pair[costs.length];
        for (int i = 0; i < costs.length; i++) {
            arr[i] = new pair(costs[i][0], costs[i][1]);
        }
        Arrays.sort(arr);
        int f = costs.length / 2;
        int l = costs.length / 2;
        int sum = 0;
        for (int i = costs.length - 1; i >= 0 ; i--) {
            if (f != 0 && l != 0) {
                if (arr[i].x < arr[i].y) {
                    f--;
                    sum += arr[i].x;
                }
                else if (arr[i].x > arr[i].y) {
                    l--;
                    sum += arr[i].y;
                } else {
                    if (l > f) {
                        l--;
                        sum += arr[i].y;
                    } else {
                        f--;
                        sum += arr[i].x;
                    }
                }
            } else {
                if (l == 0) sum += arr[i].x;
                if (f == 0) sum += arr[i].y;
            }
        }
        return sum;
    }
}