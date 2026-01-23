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
        if (head == null || head.next == null)
            return null;
        int size = 0;
        ListNode temp = head;
        ListNode dummy = new ListNode(0);
        dummy.next = temp;

        while (temp != null) {
            size++;
            temp = temp.next;
        }

        temp = head;

        if(size - n == 0){
            dummy.next = dummy.next.next;
            return dummy.next;
        }

        for (int i = 1; i < size - n; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return dummy.next;
    }
}

/*
1(1), 2(2), 3(3), 4(4), 5(5)

n=2 => remove 4
i = 1 => 1 < size - n = 5-2 = 3
i=2 => 2 < 3
*/