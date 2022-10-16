class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        Arrays.sort(nums);
        helper(0, nums, ans, tmp);
        return ans;
    }

    public void helper(int i, int [] nums, List<List<Integer>> ans, List<Integer> tmp) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        tmp.add(nums[i]);
        helper(i+1, nums, ans, tmp);
        tmp.remove(tmp.size() - 1);
        while (i+1 < nums.length && nums[i] == nums[i+1]) i++;
        helper(i+1, nums, ans, tmp);
    }
}