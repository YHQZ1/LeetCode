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
    public ListNode reverse(ListNode head){
        ListNode rev = null;

        while(head != null){
            ListNode temp = new ListNode(head.val);

            temp.next = rev;
            rev = temp;

            head = head.next;
        }
        return rev;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode New = reverse(head);
        while(head != null && New != null){
            if(head.val != New.val){
                return false;
            }
            head = head.next;
            New = New.next;
        }
        return head == null && New == null;
    }
}