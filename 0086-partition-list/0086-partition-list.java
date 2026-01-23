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
        ListNode lesser = new ListNode(0);
        ListNode greater = new ListNode(0);

        ListNode small = lesser;
        ListNode big = greater;

        ListNode curr = head;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = null;

            if(curr.val < x){
                small.next = curr;
                small = small.next;
            } else {
                big.next = curr;
                big = big.next;
            }

            curr = next;
        }

        small.next = greater.next;
        return lesser.next;
    }
}