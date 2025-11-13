class Solution {
    public void getPerms(int[] nums, int idx, List<List<Integer>> result) {
        if (idx == nums.length) {
            List<Integer> perm = new ArrayList<>();
            for (int n : nums)
                perm.add(n);
            result.add(perm);
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            swap(nums, i, idx);
            getPerms(nums, idx + 1, result);
            swap(nums, i, idx);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        getPerms(nums, 0, result);

        Set<List<Integer>> unique = new HashSet<>(result);
        List<List<Integer>> finalRes = new ArrayList<>(unique);
        return finalRes;
    }
}