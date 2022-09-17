/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public static Node copyRandomList(Node head) {

            Node newHead = new Node(-1);
            Node headPointer = head;
            Node newHeadPointer = newHead;
            HashMap<Node, Integer> index = new HashMap<>();
            ArrayList<Integer> ref = new ArrayList<>();

            int idx = 0;
            while (headPointer != null) {
                index.put(headPointer, idx++);
                headPointer = headPointer.next;
            }

            Node [] references = new Node[idx];
            headPointer = head;
            idx = 0;

            while (headPointer != null) {
                if (headPointer.random != null) {
                    ref.add(idx);
                    ref.add(index.get(headPointer.random));
                }
                idx++;
                headPointer = headPointer.next;
            }

            headPointer = head;
            int i = 0;
            while (headPointer != null) {
                newHeadPointer.next = new Node(headPointer.val); // create a new node
                references[i++] = newHeadPointer.next;
                newHeadPointer = newHeadPointer.next;
                headPointer = headPointer.next;
            }

            for (int j = 0; j < ref.size()-1; j+=2) {
                references[ref.get(j)].random = references[ref.get(j+1)];
            }

            return newHead.next;
        }
}