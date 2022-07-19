class Solution {
    static int [] occurrence;
    static int [] memo;

    public static int maxScoreWords(String[] words, char[] letters, int[] score) {

        occurrence = new int[26];
        for (int i = 0; i < letters.length; i++) {
            occurrence[letters[i] - 'a']++;
        }
        memo = new int[words.length];
        Arrays.fill(memo, -1);

        return dp(0, words.length, words, score);
    }


    public static int dp(int i, int n, String [] words, int [] score) {
        if (i == n) return 0;
        if (memo[i] != -1) {
            System.out.println("memo[" + i + "] = " + memo[i]);
            return memo[i];
        }
        int ans;
        if (valid(words[i])) {

            go(words[i]);
            int take = dp(i + 1, n, words, score) + getScore(words[i], score);
            back(words[i]);
            int leave = dp(i + 1, n, words, score);

            ans = Math.max(take, leave);
        }
        else ans = dp(i + 1, n, words, score);

        return ans;
    }

    public static boolean valid(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (Map.Entry<Character, Integer> e: map.entrySet()){
            if (occurrence[e.getKey() - 'a'] < e.getValue()) return false;
        }
        return true;
    }

    public static void go (String s){
        for (int i = 0; i < s.length(); i++) {
            occurrence[s.charAt(i) - 'a']--;
        }
    }

    public static void back (String s) {
        for (int i = 0; i < s.length(); i++) {
            occurrence[s.charAt(i) - 'a']++;
        }
    }

    public static int getScore (String s, int [] score) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += score[s.charAt(i) - 'a'];
        }
        return sum;
    }
}