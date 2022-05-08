class Solution {
    
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int x:stones) {
            pq.add(x);
        }
        while (pq.size() >= 2){
            System.out.println(pq); 
            int x = pq.poll();
            int y = pq.poll();
            if(Math.abs(x-y)!=0) pq.add(Math.abs(x - y));

        }
        if(pq.size()==0)return 0;
        else return pq.poll();
    }
}