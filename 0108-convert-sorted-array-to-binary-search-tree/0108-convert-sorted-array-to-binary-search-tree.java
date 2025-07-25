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
    public TreeNode insert(int[] arr, int left, int right){
        if(left > right) return null;
        int mid = left + (right-left)/2;
        TreeNode newNode = new TreeNode(arr[mid]);

        newNode.left = insert(arr, left, mid-1);
        newNode.right = insert(arr, mid+1, right);

        return newNode;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return insert(nums, 0, nums.length-1);
    }
}