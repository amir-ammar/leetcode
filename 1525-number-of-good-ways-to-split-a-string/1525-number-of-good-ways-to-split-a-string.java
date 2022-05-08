class Solution {
    public int numSplits(String s) {
        int n = s.length();
        HashSet<Character> hash = new HashSet<>();
        int [] distinct1 = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            hash.add(s.charAt(i));
            distinct1[i] = hash.size();
        }
        hash = new HashSet<>();
        int [] distinct2 = new int[s.length()];
        for (int i = s.length()-1; i >=0; i--) {
            hash.add(s.charAt(i));
            distinct2[i] = hash.size();
        }

        int ans = 0;
        for (int i = 1; i < n; i++) {
            if(distinct1[i-1]==distinct2[i])ans++;
        }
        return ans;
    }
}