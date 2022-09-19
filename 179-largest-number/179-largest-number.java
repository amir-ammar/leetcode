class Solution {
        
        
        
    static class Number implements Comparable<Number> {
        String val;
        Number(String val) {
            this.val = val; 
        }

        public int compareTo(Number n) {
            String tmp1 = this.val + n.val;
            String tmp2 = n.val + this.val;
            return tmp2.compareTo(tmp1);
        }
    }
    public static String largestNumber(int[] nums) {
        PriorityQueue<Number> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            pq.add(new Number(String.valueOf(nums[i])));
        }
        StringBuilder ans = new StringBuilder();
        while (!pq.isEmpty()) ans.append(Objects.requireNonNull(pq.poll()).val);
        boolean zero = false;
        for (int i = 0; i < ans.length(); i++) {
            if (ans.charAt(i) != '0') {zero = true; break;}
        }
        if (!zero) return "0";
        else return ans.toString();
    }
}