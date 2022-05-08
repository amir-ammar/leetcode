import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    Queue q1;
    Queue q2;
    public MyStack(){
        q1 = new LinkedList<Integer>();
        q2 = new LinkedList<Integer>();
    }

    public void push(int x){
        q1.add(x);
    }

    public int pop(){
        while(q1.size()!=1){
            q2.add(q1.poll());
        }

        int pop = (int)q1.poll();
        while(!q2.isEmpty()){
            q1.add(q2.poll());
        }


        return pop;
    }


    public int top(){
        int top = -1;
        while(!q1.isEmpty()){
            if(q1.size()==1){
                top = (int)q1.peek();
            }
            q2.add(q1.poll());
        }


        while(!q2.isEmpty()){
            q1.add(q2.poll());
        }

        return top;
    }

    public boolean empty(){
        return q1.isEmpty();
    }

    

    

}
