/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
    Map<Integer, TreeNode> nodes = new HashMap<>();

    public void buildGraph(TreeNode node) {
        if (node == null)
            return;

        nodes.put(node.val, node);
        graph.putIfAbsent(node, new ArrayList<>());

        if (node.left != null) {
            graph.putIfAbsent(node.left, new ArrayList<>());

            graph.get(node).add(node.left);
            graph.get(node.left).add(node);

            buildGraph(node.left);
        }

        if (node.right != null) {
            graph.putIfAbsent(node.right, new ArrayList<>());

            graph.get(node).add(node.right);
            graph.get(node.right).add(node);

            buildGraph(node.right);
        }
    }

    public int amountOfTime(TreeNode root, int start) {
        buildGraph(root);

        TreeNode startNode = nodes.get(start);

        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        q.offer(startNode);
        visited.add(startNode);

        int minutes = -1;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                for (TreeNode neighbor : graph.get(curr)) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        q.offer(neighbor);
                    }
                }
            }
            minutes++;
        }
        return minutes;
    }
}