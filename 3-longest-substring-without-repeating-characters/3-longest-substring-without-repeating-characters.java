class Solution {
    public  int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;
        int ans = 0;
        HashSet<Character> hs = new HashSet<>();
        while(true){
            if(r==s.length())break;
            if(!hs.contains(s.charAt(r))){
                hs.add(s.charAt(r));
                r++;
            }else{
                hs.remove(s.charAt(l));
                l++;
            }
            ans = Math.max(ans , hs.size());
        }
        return ans;
    }
}