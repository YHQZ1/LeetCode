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
    private boolean dfs(TreeNode root, StringBuilder sb, int value) {
        if (root == null)
            return false;
        if (root.val == value)
            return true;

        sb.append('L');
        if (dfs(root.left, sb, value))
            return true;
        sb.deleteCharAt(sb.length() - 1);

        sb.append('R');
        if (dfs(root.right, sb, value))
            return true;
        sb.deleteCharAt(sb.length() - 1);

        return false;
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        dfs(root, s1, startValue);
        dfs(root, s2, destValue);

        int i = 0, j = 0;

        while (i < s1.length() && j < s2.length() && s1.charAt(i) == s2.charAt(j)) {
            s1.deleteCharAt(i);
            s2.deleteCharAt(j);
        }

        for (i = 0; i < s1.length(); i++) {
            s1.setCharAt(i, 'U');
        }

        return s1.toString() + s2.toString();
    }
}