class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        helper(0, nums, ans, tmp);
        return ans;
    }

    public void helper(int i, int [] nums, List<List<Integer>> ans, List<Integer> tmp) {
        if (Integer.bitCount(i) == nums.length) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if ((i & (1 << j)) == 0) {
                tmp.add(nums[j]);
                helper(i | (1 << j), nums, ans, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}