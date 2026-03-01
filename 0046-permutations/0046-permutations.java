class Solution {
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void getPermutations(int[] nums, int index, List<List<Integer>> result) {
        if (index == nums.length) {
            List<Integer> perm = new ArrayList<>();
            for (int n : nums)
                perm.add(n);
            result.add(perm);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            getPermutations(nums, index + 1, result);
            swap(nums, i, index);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        getPermutations(nums, 0, result);
        return result;
    }
}