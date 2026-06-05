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
    public void helper(TreeNode root, List<List<Integer>> list, int depth) {
        if (root == null)
            return;

        if (list.size() <= depth)
            list.add(new ArrayList<>());

        list.get(depth).add(root.val);

        helper(root.left, list, depth + 1);
        helper(root.right, list, depth + 1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> bfs = new ArrayList<>();
        helper(root, bfs, 0);
        return bfs;
    }
}