class Solution {
    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        ArrayList<Character> arr = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= '0' && s.charAt(i) <= '9')) arr.add(s.charAt(i));
        }
        System.out.println(arr);
        for (int i = 0; i < arr.size() / 2; i++) {
            if(arr.get(i) != arr.get(arr.size()-i-1)) return false;
        }
        return true;
    }
}