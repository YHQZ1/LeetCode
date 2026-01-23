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
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        ListNode partitioned = new ListNode(0);
        dummy.next = partitioned;
        ListNode temp = head;

        while (temp != null) {
            if (temp.val < x) {
                partitioned.next = new ListNode(temp.val);
                partitioned = partitioned.next;
            }

            temp = temp.next;
        }

        temp = head;

        while (temp != null) {
            if (temp.val >= x) {
                partitioned.next = new ListNode(temp.val);
                partitioned = partitioned.next;
            }

            temp = temp.next;
        }

        return dummy.next.next;
    }
}