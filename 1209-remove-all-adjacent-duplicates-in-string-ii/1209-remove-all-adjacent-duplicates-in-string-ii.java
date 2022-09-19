class Solution {
    static class Item {
        char c;
        int freq;
        Item(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }
        public String toString(){
            return c + " " + freq;
        }
    }


    public static String removeDuplicates(String s, int k) {

        Stack<Item> st1 = new Stack<>();
        Stack<Item> st2 = new Stack<>();
        char c = s.charAt(0);
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
//            System.out.println(st1);
            if (c != s.charAt(i)) {
                st1.add(new Item(c, count));
                c = s.charAt(i);
                count = 1;
            } else count++;
        }
        st1.add(new Item(c, count));
//        System.out.println(st1);


        while (st1.size() != 0) {
            Item tmp = st1.pop();
            if (tmp.freq != k) {
                tmp.freq = tmp.freq % k;
                if (st2.size() != 0) {
                    if (st2.peek().c == tmp.c) {
                        if (st2.peek().freq + tmp.freq < k || st2.peek().freq + tmp.freq > k)
                            st2.push(new Item(tmp.c, (st2.pop().freq + tmp.freq) % k));
                        else st2.pop();
                    } else st2.push(tmp);
                } else {
                    st2.push(tmp);
                }
            }
        }


        StringBuilder sb = new StringBuilder();

        while (!st2.isEmpty()) {
            Item tmp = st2.pop();
            for (int i = 0; i < tmp.freq; i++) {
                sb.append(tmp.c);
            }
        }
        return sb.toString();
    }
}