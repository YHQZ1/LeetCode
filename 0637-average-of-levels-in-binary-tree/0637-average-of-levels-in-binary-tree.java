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
    public void helper(TreeNode root, List<List<Double>> list, int depth) {
        if (root == null)
            return;

        if (list.size() <= depth)
            list.add(new ArrayList<>());

        list.get(depth).add((double) root.val);

        helper(root.left, list, depth + 1);
        helper(root.right, list, depth + 1);
    }

    public List<Double> convert(List<List<Double>> list) {
        List<Double> result = new ArrayList<>();
        for (List<Double> inner : list) {
            double sum = 0;
            int nodes = 0;
            for (double x : inner) {
                sum += x;
                nodes++;
            }
            result.add(sum/nodes);
        }
        return result;
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<List<Double>> list = new ArrayList<>();
        helper(root, list, 0);
        return convert(list);
    }
}