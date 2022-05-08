class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int sum = 0;
        int ans = 0;
        for(int i = 0 ; i<nums.length ; i++){
            if(nums[i]==1){
                sum++;
            }else{
                ans = Math.max(ans , sum);
                sum = 0;
            }
        }
        ans = Math.max(sum , ans);
        return ans;
    }
}