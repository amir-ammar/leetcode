class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(ans, list, 1, k, n);
        return ans;
    }

    public void helper(List<List<Integer>> ans, List<Integer> list, int i, int k, int n) {
        if (k == 0) {
            ans.add(new ArrayList<>(list));

            return;
        }
        if (i > n) return;
        list.add(i);
        helper(ans, list, i+1, k - 1, n);
        list.remove(list.size() - 1);
        helper(ans, list, i+1, k, n);
    }
}