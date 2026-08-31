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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;

        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }

        int firstCP = -1;
        int prevCP = -1;
        int minDistance = Integer.MAX_VALUE;
        int maxDistance = -1;

        for (int i = 1; i < list.size() - 1; i++) {
            int prev = list.get(i - 1);
            int curr = list.get(i);
            int next = list.get(i + 1);

            boolean isCritical =
                (curr > prev && curr > next) ||
                (curr < prev && curr < next);

            if (isCritical) {
                if (firstCP == -1)
                    firstCP = i;

                if (prevCP != -1)
                    minDistance = Math.min(minDistance, i - prevCP);

                maxDistance = i - firstCP;
                prevCP = i;
            }
        }

        if (prevCP == -1 || prevCP == firstCP)
            return new int[] { -1, -1 };

        return new int[] { minDistance, maxDistance };
    }
}