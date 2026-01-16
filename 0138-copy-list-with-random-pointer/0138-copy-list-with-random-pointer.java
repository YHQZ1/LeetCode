/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();

        Node curr = head;

        while (curr != null) {
            Node clone = new Node(curr.val);
            map.put(curr, clone);

            curr = curr.next;
        }

        curr = head;

        while (curr != null) {
            Node clone = map.get(curr);

            clone.next = (curr.next == null) ? null : map.get(curr.next);
            clone.random = (curr.random == null) ? null : map.get(curr.random);

            curr = curr.next;
        }
        return map.get(head);
    }
}