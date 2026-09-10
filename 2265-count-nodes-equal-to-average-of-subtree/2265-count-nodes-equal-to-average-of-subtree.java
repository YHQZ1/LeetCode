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
    private int ans = 0;

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[] { 0, 0 };
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int sum = root.val + left[0] + right[0];
        int nodes = 1 + left[1] + right[1];

        if (root.val == sum / nodes) {
            ans++;
        }

        return new int[] { sum, nodes };
    }

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }
}