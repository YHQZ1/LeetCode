class Solution {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        backtrack(nums, visited, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, boolean[] visited, 
                           List<Integer> curr, List<List<Integer>> result) {
        if (curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (visited[i]) continue;

            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])
                continue;

            visited[i] = true;
            curr.add(nums[i]);

            backtrack(nums, visited, curr, result);

            visited[i] = false;
            curr.remove(curr.size() - 1);
        }
    }
}
