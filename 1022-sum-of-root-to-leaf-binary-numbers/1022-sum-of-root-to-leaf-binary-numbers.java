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

    public int dfs(TreeNode root, StringBuilder binary) {
        if (root == null)
            return 0;

        binary.append(root.val);

        int sum = 0;

        if (root.left == null && root.right == null) {
            sum = Integer.parseInt(binary.toString(), 2);
        } else {
            sum = dfs(root.left, binary) + dfs(root.right, binary);
        }

        binary.deleteCharAt(binary.length() - 1);

        return sum;
    }

    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, new StringBuilder());
    }
}