class Solution {
    private void backtrack(List<List<Integer>> list, List<Integer> temp, int[] nums, int index) {
        list.add(new ArrayList<>(temp));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1])
                continue;
            temp.add(nums[i]);
            backtrack(list, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }
}