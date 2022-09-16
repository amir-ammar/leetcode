class MinStack {

    PriorityQueue<Integer> pq;
    Stack<Integer> st;

    public MinStack() {
        pq = new PriorityQueue<>();
        st = new Stack<>();
    }

    public void push(int val) {
        pq.add(val);
        st.push(val);
    }

    public void pop() {
        pq.remove(st.pop());
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return pq.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */