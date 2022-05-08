class Solution {
    static HashMap<Integer, Integer> map;
    public static int dp(int n){
        if(map.get(n) != null)return map.get(n);
        map.put(n, Math.min(1 + (n%3) + dp(n/3), 1 + (n%2) + dp(n/2)));
        return map.get(n);
    }


    public int minDays(int n) {
        map = new HashMap<>();
        map.put(0,0);
        map.put(1,1);
        return dp(n);
    }
}