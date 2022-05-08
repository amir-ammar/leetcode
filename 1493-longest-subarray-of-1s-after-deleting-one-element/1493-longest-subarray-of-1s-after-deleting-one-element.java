class Solution {
   public static int longestSubarray(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> arr = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if(nums[i]==0){
                arr.add(sum);
                arr.add(0);
                sum = 0;
            }else sum+=nums[i];
        }
        arr.add(sum);
        int [] dp = new int[arr.size()];
        dp[0] = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            if(arr.get(i-1)==0){
                dp[i] += arr.get(i) + ((i-2)>=0?arr.get(i-2):0);
            }else{
                dp[i] = arr.get(i);
            }
        }
        int res = 0;
        for (int i = 0; i < arr.size(); i++) {
            res = Math.max(res, dp[i]);
        }
        return (arr.size()==1)?(res>0?(res-1):0):res;
    }
}