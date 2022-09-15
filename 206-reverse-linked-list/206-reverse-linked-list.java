/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public static ListNode reverseList(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode tmp = head.next;
        head.next = null;
        while (tmp.next != null) {
            ListNode next = tmp.next;
            tmp.next = head;
            head = tmp;
            tmp = next;
        }
        tmp.next = head;
        return tmp;
    }
}