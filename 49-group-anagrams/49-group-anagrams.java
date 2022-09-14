class Solution {
    
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            int [] count = new int[26];
            for (int j = 0; j < strs[i].length(); j++) {
                count[strs[i].charAt(j) - 'a']++;
            }
            String key = "";
            for (int j = 0; j < 26; j++) {
                if (count[j] != 0) key = key + "" + count[j] + "" + (char)(j+'a');
            }
            System.out.println(key);
            if (map.containsKey(key)) {
                ArrayList<String> tmp = map.get(key);
                tmp.add(strs[i]);
                map.put(key, tmp);
            } else {
                ArrayList<String> tmp = new ArrayList<>();
                tmp.add(strs[i]);
                map.put(key, tmp);
            }
            
        }
        for(Map.Entry<String, ArrayList<String>> entry: map.entrySet()){
            List<String> tmp = new ArrayList<>();
            for (int j = 0; j < entry.getValue().size(); j++) {
                tmp.add(entry.getValue().get(j));
            }
            ans.add(tmp);
        }
        return ans;
    }
}