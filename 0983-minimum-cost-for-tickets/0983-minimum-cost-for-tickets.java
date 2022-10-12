class Solution {
    public static int mincostTickets(int[] days, int[] costs) {
        int [] arr = new int[367];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < days.length; i++) {
            set.add(days[i]);
        }

        for (int i = 1; i < arr.length; i++) {
            if(set.contains(i)) {
                arr[i] = costs[0] + arr[i-1];
                arr[i] = Math.min(arr[i], costs[1] + arr[(i-7) >= 1 ? (i-7) : 0]);
                arr[i] = Math.min(arr[i], costs[2] + arr[(i-30) >= 1 ? (i-30) : 0]);
            } else {
                arr[i] = arr[i-1];
            }
        }
        return arr[days[days.length - 1]];
    }
}