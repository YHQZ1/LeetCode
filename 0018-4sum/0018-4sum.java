class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> quadruplet = new ArrayList<>();

        for (int k = 0; k < nums.length - 3; k++) {
            if (k > 0 && nums[k] == nums[k - 1])
                continue;
            for (int l = k + 1; l < nums.length - 2; l++) {
                if (l > k + 1 && nums[l] == nums[l - 1])
                    continue;

                int i = l + 1;
                int j = nums.length - 1;
                while (i < j) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum < target)
                        i++;
                    else if (sum > target)
                        j--;
                    else if (sum == target) {
                        quadruplet.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        while (i < j && nums[i] == nums[i + 1])
                            i++;
                        while (j > i && nums[j] == nums[j - 1])
                            j--;
                        i++;
                        j--;
                    }
                }
            }
        }
        return quadruplet;
    }
}