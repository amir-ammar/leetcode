class Solution {
    static ArrayDeque<Integer> tmpAns;
    static ArrayDeque<ArrayDeque<Integer>> ans;
    static int [] arr;
    public static void helper(int i, int t) {
        if(t == 0 && i == arr.length) {
            ans.add(new ArrayDeque<>(tmpAns));
        }
        if (i == arr.length) return;
        for (int j = 0; j <= t / arr[i]; j++) {
            if (j != 0) tmpAns.add(arr[i]);
            helper(i+1, t - (j * arr[i]));
        }
        for (int j = 0; j < t / arr[i]; j++) {
            tmpAns.removeLast();
        }
    }


    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        arr = candidates;
        tmpAns = new ArrayDeque<>();
        ans = new ArrayDeque<>();
        helper(0, target);
        List<List<Integer>> res = new ArrayList<>();
        while (ans.size() != 0) {
            res.add(new ArrayList<>());
            while (ans.getFirst().size() != 0) {
                res.get(res.size() - 1).add(ans.getFirst().getFirst());
                ans.getFirst().removeFirst();
            }
            ans.removeFirst();
        }
        return res;
    }
}