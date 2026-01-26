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
    public int postIdx;

    public int search(int[] arr, int target, int left, int right) {
        for (int i = left; i <= right; i++) {
            if (target == arr[i])
                return i;
        }
        return -1;
    }

    public TreeNode helper(int[] postorder, int[] inorder, int left, int right) {
        if (left > right)
            return null;
        TreeNode root = new TreeNode(postorder[postIdx]);

        int inIdx = search(inorder, postorder[postIdx], left, right);
        postIdx--;

        root.right = helper(postorder, inorder, inIdx + 1, right);
        root.left = helper(postorder, inorder, left, inIdx - 1);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIdx = postorder.length - 1;
        return helper(postorder, inorder, 0, inorder.length - 1);
    }
}