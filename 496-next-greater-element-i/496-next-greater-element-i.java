class Solution {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums2.length; i++) {
            while (true) {
                if (pq.size() == 0) break;
                int tmp = pq.poll();
                if (nums2[i] > tmp) {
                    map.put(tmp, nums2[i]);
                    set.remove(tmp);
                } else { 
                    pq.add(tmp);
                    break; 
                }
            }
            if (set.contains(nums2[i])) pq.add(nums2[i]);
        }
        // System.out.println(map);
        int [] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.getOrDefault(nums1[i], -1);
        }
        return ans;
    }
}