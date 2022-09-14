class Solution {
    static class pair implements Comparable<pair> {
        int x, y;
        pair(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(pair o) {
            return this.y - o.y;
        }
    }


    public static int[] topKFrequent(int[] nums, int k) {
        ArrayList<pair> arr = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            arr.add(new pair(entry.getKey(), entry.getValue()));
        }
        Collections.sort(arr, Collections.reverseOrder());
        int [] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = arr.get(i).x;
        }
        return ans;
    }
}