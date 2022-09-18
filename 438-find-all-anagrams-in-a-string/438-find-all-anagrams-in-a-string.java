class Solution {
    public static List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> tmp = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for (Character ele: p.toCharArray()) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
            tmp.put(ele, tmp.getOrDefault(ele, 0) + 1);
        }
        int len = p.length() - 1;
        for (int i = 0; i < s.length(); i++) {
            if (tmp.containsKey(s.charAt(i))) {
                int occur = tmp.get(s.charAt(i));
                if (occur == 1) tmp.remove(s.charAt(i));
                else tmp.put(s.charAt(i), tmp.get(s.charAt(i)) - 1);
            } else {
                tmp = new HashMap<>(map);
                if (map.containsKey(s.charAt(i))) {
                    char c = s.charAt(i);
                    int count = map.get(c);
                    for (int j = i-1; j >= 0 ; j--) {
                        if (s.charAt(j) == c) count--;
                        if (s.charAt(j) == c && count == 0) {
                            i = j;
                            break;
                        }
                    }
                }
//                System.out.println(tmp);
            }
            if (tmp.size() == 0) {
                ans.add(i - len);
                tmp.put(s.charAt(i - len), 1);
            }
        }

        return ans;
    }
}