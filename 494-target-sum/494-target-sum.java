class Solution {
    
    static int [] arr;
    static int[][] memo;
    static int t;
    static int total;
    public  static int dp(int ind, int sum){
        
        if(sum==t && ind==arr.length){
            return 1;
        }else if(ind==arr.length){
            return 0;
        }


        if(memo[ind][sum+total]!=-1)return memo[ind][sum+total];

        return memo[ind][sum+total] = dp(ind+1, sum+arr[ind]) + dp(ind+1, sum-arr[ind]);
    }
    
    public static int findTargetSumWays(int[]nums, int target){
        arr = nums;
        total = Arrays.stream(arr).sum();
        memo = new int[arr.length][2*total+1];
        t = target;
        for (int [] x:memo) {
            Arrays.fill(x, -1);
        }
        return (dp(0,0));
    }
}