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
    private boolean dfs(TreeNode root, int target, StringBuilder path) {
        if (root == null) {
            return false;
        }

        if (root.val == target) {
            return true;
        }

        path.append('L');
        if (dfs(root.left, target, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);

        path.append('R');
        if (dfs(root.right, target, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);

        return false;
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        dfs(root, startValue, sb1);
        dfs(root, destValue, sb2);

        int i = 0, j = 0;

        while (i < sb1.length() && j < sb2.length() && sb1.charAt(i) == sb2.charAt(j)) {
            sb1.deleteCharAt(i);
            sb2.deleteCharAt(j);
        }

        for (i = 0; i < sb1.length(); i++) {
            sb1.setCharAt(i, 'U');
        }

        return sb1.toString() + sb2.toString();
    }
}