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
    public void inorder(List<Integer> list, TreeNode root) {
        if (root == null)
            return;

        inorder(list, root.left);
        list.add(root.val);
        inorder(list, root.right);
    }

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> tree = new ArrayList<>();

        inorder(tree, root);

        int i = 0, j = tree.size() - 1;

        while (i < j) {
            int sum = tree.get(i) + tree.get(j);
            if (sum == k)
                return true;
            else if (sum < k)
                i++;
            else
                j--;
        }
        return false;
    }
}