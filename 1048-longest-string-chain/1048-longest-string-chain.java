class Solution {
    public static int longestStrChain(String[] words) {
        int n = words.length;
        Arrays.sort(words, (a, b)->Integer.compare(a.length(), b.length()));
        int res = 0;
        HashMap<String, Integer> hash = new HashMap<>();
        for (String word:words) {

            hash.put(word, 1);
            
            for (int i = 0; i < word.length(); i++) {
                StringBuilder s = new StringBuilder(word);
                String next = s.deleteCharAt(i).toString();
                if(hash.containsKey(next)){
                    hash.put(word, Math.max(hash.get(word), hash.get(next)+1));
                }
            }

            res = Math.max(res, hash.get(word));

        }
        return res;
    }
    
}