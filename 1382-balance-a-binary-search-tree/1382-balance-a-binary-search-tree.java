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
    private void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null)
            return;

        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }

    private TreeNode helper(List<Integer> list, int left, int right) {
        if (left > right)
            return null;

        int mid = left + (right - left) / 2;

        TreeNode leftSubtree = helper(list, left, mid - 1);
        TreeNode rightSubtree = helper(list, mid + 1, right);

        TreeNode node = new TreeNode(list.get(mid), leftSubtree, rightSubtree);
        return node;
    }

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(root, list);

        return helper(list, 0, list.size() - 1);
    }
}