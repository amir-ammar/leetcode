class Solution {
    public static boolean checkValidString(String s) {
        Stack<Integer> c = new Stack<>();
        Stack<Integer> as = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') c.add(i);
            else if (s.charAt(i) == '*') as.add(i);
            else {
                if (c.isEmpty() && as.isEmpty()) return false;
                else if (c.isEmpty()) as.pop();
                else c.pop();
            }
        }
        if (c.isEmpty()) return true;

        while (!c.isEmpty() && !as.isEmpty()) {
            if (c.peek() < as.peek()) {
                as.pop();
                c.pop();
            } else return false;
        }
        return c.isEmpty();
    }
}