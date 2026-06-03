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
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) return true;
        StringBuilder sb = new StringBuilder();

        ListNode temp = head;

        while(temp != null){
            sb.append(temp.val);
            temp = temp.next;
        }
        
        String str = sb.toString();
        return str.equals(new StringBuilder(str).reverse().toString());
    }
}