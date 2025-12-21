class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> triplet = new HashSet<>();
        int target = 0;
        for (int k = 0; k < nums.length; k++) {
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < target)
                    i++;
                else if (sum > target)
                    j--;
                else if (sum == target) {
                    triplet.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    i++;
                    j--;
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>(triplet);
        return result;
    }
}