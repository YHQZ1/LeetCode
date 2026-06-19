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

        int i = 0;
        while (i < s1.length() && i < s2.length() && s1.charAt(i) == s2.charAt(i))
            i++;

        StringBuilder result = new StringBuilder();
        for (int k = i; k < s1.length(); k++)
            result.append('U');
        result.append(s2, i, s2.length());

        return result.toString();
    }
}