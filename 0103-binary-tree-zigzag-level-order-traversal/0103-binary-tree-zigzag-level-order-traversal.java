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

        if (depth % 2 == 0) {
            list.get(depth).add(root.val);
        } else {
            list.get(depth).add(0, root.val);
        }

        helper(root.left, list, depth + 1);
        helper(root.right, list, depth + 1);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigzag = new ArrayList<>();
        helper(root, zigzag, 0);
        return zigzag;
    }
}