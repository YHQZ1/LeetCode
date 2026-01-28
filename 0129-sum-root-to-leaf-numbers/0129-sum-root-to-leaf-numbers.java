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
    public int dfs(TreeNode root, int currNumber) {
        if (root == null)
            return 0;

        currNumber = currNumber * 10 + root.val;

        if (root.left == null && root.right == null)
            return currNumber;

        return dfs(root.left, currNumber) + dfs(root.right, currNumber);
    }

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
}