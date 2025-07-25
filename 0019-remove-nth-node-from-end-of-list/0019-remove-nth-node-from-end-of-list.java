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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode s = head, temp = head;
        while(s != null){
            size++;
            s=s.next;
        }
        if(n == size) return head.next;

        for(int i=0; i<size-n-1; i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }
}