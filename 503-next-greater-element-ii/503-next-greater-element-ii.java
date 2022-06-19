class Solution {
    public static int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        Integer [] pgr = new Integer[n];
        Integer [] ngr = new Integer[n];

        Stack<Integer> st2 = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!st2.isEmpty() && nums[i] > nums[st2.peek()]){
                ngr[st2.peek()] = i;
                st2.pop();
            }
            st2.add(i);
        }

        for (int i = 0; i < n; i++) {
            while (!st2.isEmpty() && nums[i] > nums[st2.peek()]){
                ngr[st2.peek()] = i;
                st2.pop();
            }
        }



        int [] res = new int[n];
        for (int i = 0; i < n; i++) {
            if(ngr[i] != null) res[i] = nums[ngr[i]];
            else if (pgr[i] != null) res[i] = nums[pgr[i]];
            else if (pgr[i] == null) res[i] = -1;
        }

       return res;
    }
}