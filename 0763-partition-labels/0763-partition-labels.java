class Solution {
    public static List<Integer> partitionLabels(String s) {
        int [] occ = new int[26];
        for(int i = 0; i < s.length(); i++){
            occ[s.charAt(i) - 'a']++;
        }
        List<Integer> list = new ArrayList<>();
        int last = -1;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
            occ[s.charAt(i) - 'a']--;
            if (occ[s.charAt(i) - 'a'] == 0) set.remove(s.charAt(i));

            if (set.size() == 0) {
                list.add(i - last);
                last = i;
            }
        }
        return list;
    }
}