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
    private int count(TreeNode root) {
        if (root == null)
            return 0;

        return 1 + count(root.left) + count(root.right);
    }

    private int sum(TreeNode root) {
        if (root == null)
            return 0;

        return root.val + sum(root.left) + sum(root.right);
    }

    private boolean helper(TreeNode root) {
        int total = sum(root);
        int nodes = count(root);

        return root.val == Math.floor(total / nodes);
    }

    public int averageOfSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int count = 0;

        if (helper(root)) {
            count++;
        }

        count += averageOfSubtree(root.left);
        count += averageOfSubtree(root.right);

        return count;
    }
}