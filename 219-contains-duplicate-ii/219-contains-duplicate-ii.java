class Solution {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer , Integer> h = new HashMap();
        for(int i = 0 ; i<nums.length ; i++){
            if(h.containsKey(nums[i])){
                int z = h.get(nums[i]);
                if(Math.abs(z-i)<=k){
                    return true;
                }else{
                    h.remove(nums[i] , i);
                }
            }
            h.put(nums[i] , i);
        }
        return false;
    }
}
   