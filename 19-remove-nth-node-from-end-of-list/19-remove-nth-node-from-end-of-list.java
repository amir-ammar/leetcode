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
    public static int count (ListNode head) {
        int cnt = 0;
        ListNode tmp = head;
        while (tmp != null){
            cnt++;
            tmp = tmp.next;
        }
        return cnt;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int len = count(head);
        if (len == n)return head.next;
        int ele = len - n;
        ListNode tmp = head;
        int c = 1;
        while (c != ele) {
            c++;
            tmp = tmp.next;
        }
        tmp.next = tmp.next.next;
        return head;
    }
}