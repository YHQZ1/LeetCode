class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> triplet = new ArrayList<>();

        for (int k = 0; k < nums.length - 2; k++) {
            if (k > 0 && nums[k] == nums[k - 1])
                continue;

            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0)
                    i++;
                else if (sum > 0)
                    j--;
                else if (sum == 0) {
                    triplet.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (i < j && nums[i] == nums[i + 1])
                        i++;
                    while (j > i && nums[j] == nums[j - 1])
                        j--;
                    i++;
                    j--;
                }
            }
        }
        return triplet;
    }
}