class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                (a, b) -> a.val - b.val);

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for (ListNode node : lists) {
            if (node != null)
                pq.offer(node);
        }

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            curr.next = node;
            curr = curr.next;

            if (node.next != null)
                pq.offer(node.next);
        }
        return dummy.next;
    }
}
