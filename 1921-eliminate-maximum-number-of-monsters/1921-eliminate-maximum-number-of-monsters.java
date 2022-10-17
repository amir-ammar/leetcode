class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        ArrayList<Integer> minutes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            minutes.add((dist[i] / speed[i]) + (((dist[i] % speed[i] != 0) ? 1 : 0)));
        }
        Collections.sort(minutes);
        int i = 0;
        int sum = 0;
        while (i < n) {
            if (minutes.get(i) - i == 0) break;
            sum++;
            i++;
        }
        return sum == 0 ? 1 : sum;
    }
}
    
    