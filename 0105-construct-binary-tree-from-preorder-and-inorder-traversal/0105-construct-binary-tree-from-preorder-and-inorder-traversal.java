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
    public int preIdx = 0;

    public int search(int[] arr, int target, int left, int right) {
        for (int i = left; i <= right; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }

    public TreeNode helper(int[] preorder, int[] inorder, int left, int right) {
        if (left > right)
            return null;

        TreeNode root = new TreeNode(preorder[preIdx]);

        int inIdx = search(inorder, preorder[preIdx], left, right);
        preIdx++;

        root.left = helper(preorder, inorder, left, inIdx - 1);
        root.right = helper(preorder, inorder, inIdx + 1, right);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, inorder.length - 1);
    }
}