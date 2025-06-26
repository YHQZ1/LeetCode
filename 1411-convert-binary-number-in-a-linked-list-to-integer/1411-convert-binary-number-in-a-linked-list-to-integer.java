class Solution {
    public int getDecimalValue(ListNode head) {
        int number = 0;
        ListNode temp = head;

        while (temp != null) {
            number = (number << 1) | temp.val; 
            temp = temp.next;
        }

        return number;
    }
}
