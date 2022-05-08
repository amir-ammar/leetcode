class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        ListNode iter=head;
        if(head==null || head.next==null) return head;
        while(iter!=null && iter.next!=null) {
            if(iter.val==iter.next.val) {
                iter.next=iter.next.next;
            } else {
                iter=iter.next;
            }
        }
        return head;
    }
}